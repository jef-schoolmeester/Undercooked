package sample.level;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import level.Level;
import level.customer.Order;
import level.recipe.Dish;
import level.recipe.Ingredient;
import level.recipe.StateDish;
import level.tools.DishTool;
import level.tools.IngredientTool;
import level.tools.Tile;
import sample.Main;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This controller manages the visual part of the Level
 * @see Order
 * @see Level
 * @see level.pizzaiolo.Pizzaiolo
 * @see IngredientTool
 * @see Tile
 * @see DishTool
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 *
 */
public class LevelController {

    @FXML
    private GridPane gameGrid;

    @FXML
    private ImageView pizzaiolo;

    @FXML
    private GridPane inventoryGrid;

    @FXML
    private GridPane custommerGrid;

    @FXML
    private ArrayList<GridPane> customers;

    @FXML
    private Label timerValue;

    @FXML
    private Label score;

    private double clickPosX;
    private double clickPosY;
    private int clickTileX;
    private int clickTileY;

    private int walking;
    public enum Walking{
        WALKING_UP,
        WALKING_DOWN,
        WALKING_LEFT,
        WALKING_RIGHT
    }
    private Walking walkingState;
    private boolean isWalking;
    private String walkingPath;

    private int ovenFlashing;

    private double timer;

    private Level level;

    /**
     * This timer manages the Visual part of the level and checks the delivered Dishes
     * First, it makes the pizzaiolo walk towards it's destination (defined by a click on a tile)
     * It also makes the oven flash when the dish inside is ready
     * This timer also manages the visual part of the orders and inventory (hand)
     * @since 2.0
     *
     */
    public AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            try {
                Thread.sleep(25);
                timer -= 0.025;
                timerValue.setText((Math.round(timer * 10.0)/10.0) + "s");

                //Algorithm that make the pizzaiolo move
                isWalking = true;
                if (Math.abs(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() - clickPosX) > 10) {
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() < clickPosX) {
                        pizzaiolo.setTranslateX(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinX() + 10);
                        walkingState = Walking.WALKING_RIGHT;

                    }
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() > clickPosX) {
                        pizzaiolo.setTranslateX(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinX() - 10);
                        walkingState = Walking.WALKING_LEFT;
                    }
                } else if(Math.abs(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() - clickPosY) > 10) {
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() < clickPosY) {
                        pizzaiolo.setTranslateY(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinY() + 10);
                        walkingState = Walking.WALKING_DOWN;
                    }
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() > clickPosY) {
                        pizzaiolo.setTranslateY(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinY() - 10);
                        walkingState = Walking.WALKING_UP;
                    }
                } else {
                    isWalking = false;
                    if (level.getPizzaiolo().getPosX() != clickTileX || level.getPizzaiolo().getPosY() != clickTileY) {
                        level.getPizzaiolo().setPos(clickTileX, clickTileY);
                    }
                }

                switch (walkingState) {
                    case WALKING_UP -> walkingPath = "up";
                    case WALKING_DOWN -> walkingPath = "down";
                    case WALKING_LEFT -> walkingPath = "left";
                    case WALKING_RIGHT -> walkingPath = "right";
                    default -> {}
                }

                //Flash the oven
                switch (checkIfDishInOvenIsCooked()) {
                    case COOKED -> {
                        ovenFlashing++;
                        if (ovenFlashing > 5) {
                            gameGrid.getChildren().get(9).setOpacity(0.5);
                        } else {
                            gameGrid.getChildren().get(9).setOpacity(1);
                        }
                        if (ovenFlashing > 10) {
                            ovenFlashing = 0;
                        }
                    }
                    case TRASH -> {
                        ovenFlashing++;
                        if (ovenFlashing > 2) {
                            gameGrid.getChildren().get(9).setOpacity(0.5);
                        } else {
                            gameGrid.getChildren().get(9).setOpacity(1);
                        }

                        if (ovenFlashing > 4) {
                            ovenFlashing = 0;
                        }
                    }
                    default -> {
                        ovenFlashing = 0;
                        gameGrid.getChildren().get(9).setOpacity(1);
                    }
                }

                //Pizzaiolo animation
                if (isWalking) {
                    walking += 1;
                    if (walking > 5) {
                        pizzaiolo.setImage(new Image(getClass().getResourceAsStream("/IB/player/"+ walkingPath +"Walk2.png")));
                    } else {
                        pizzaiolo.setImage(new Image(getClass().getResourceAsStream("/IB/player/"+ walkingPath +"Walk1.png")));
                    }
                    if (walking > 10) {
                        walking = 0;
                    }
                } else {
                    pizzaiolo.setImage(new Image(getClass().getResourceAsStream("/IB/player/"+ walkingPath +"Stand.png")));
                }
                checkDelivery();
                setOrders();
                score.setText(Math.round(level.getScore()*10.0)/10.0 + " €");


                // Sets the inventory color depending on the dish state
                if (level.getPizzaiolo().getHand().isDish()) {
                    if (level.getPizzaiolo().getHand().getDish().getStateDish() == StateDish.COOKED) {
                        inventoryGrid.setStyle("-fx-border-color: lime;" + "-fx-border-width: 2");
                    } else if (level.getPizzaiolo().getHand().getDish().getStateDish() == StateDish.TRASH) {
                        inventoryGrid.setStyle("-fx-border-color: purple;" + "-fx-border-width: 2");
                    } else {
                        inventoryGrid.setStyle("-fx-border-color: white;" + "-fx-border-width: 2");
                    }
                } else {
                    inventoryGrid.setStyle("-fx-border-color: white;" + "-fx-border-width: 2");
                }
                if (timer < 0 || level.getScore() < 0) {
                    URL url = new File("src/main/java/sample/level/endGame.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    timerValue.getScene().setRoot(root);
                    level.stop();
                    this.stop();
                }


            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    /**
     * Initialises the visual part of a level and start the timer
     * @since 1.0
     */
    public void initialize() {
        this.level = Main.level;

        for (int i = 0 ; i < Level.LEVEL_SIZE ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            gameGrid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < Level.LEVEL_SIZE ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            gameGrid.getRowConstraints().add(rowConstraints);
        }

        ArrayList<ArrayList<Tile>> table = level.getTable();
        for (int i = 0; i < Level.LEVEL_SIZE; i++) {
            for (int j = 0; j < Level.LEVEL_SIZE; j++) {
                switch (table.get(i).get(j).toString()) {
                    case "void" -> addVoidTile(i, j, table.get(i).get(j).getImagePath());
                    case "tile" -> addFloorTile(i, j, table.get(i).get(j).getImagePath());
                    default -> addToolTile(i, j, table.get(i).get(j).getImagePath());
                }
            }
        }

        this.customers = new ArrayList<>();

        this.clickPosX = 726.5;
        this.clickPosY = 426.5;
        this.clickTileX = 4;
        this.clickTileY = 4;
        this.walking = 0;
        this.ovenFlashing = 0;
        this.timer = 181.75;
        animationTimer.start();
    }

    /**
     * adds a Tile to the level playable grid gameGrid
     * @param colIndex X axis pos on the level Table
     * @param rowIndex Y axis pos on the level Table
     * @param imagePath path to it's image
     * @since 1.0
     */
    private void addFloorTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        imageView.setOnMouseClicked(e -> tileClicked(e, colIndex, rowIndex));
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    /**
     *
     * adds a VoidTile to the level playable grid gameGrid
     * A void tile cannot be interacted with
     * @param colIndex X axis pos on the level Table
     * @param rowIndex Y axis pos on the level Table
     * @param imagePath path to it's image
     * @since 1.0
     */
    private void addVoidTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    /**
     *
     * adds a tool Tile to the level playable grid gameGrid
     * The tool can be interacted with if the pizzaiolo is within 1 block
     * @param colIndex X axis pos on the level Table
     * @param rowIndex Y axis pos on the level Table
     * @param imagePath path to it's image
     * @since 1.0
     */
    private void addToolTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        imageView.setOnMouseClicked(e -> toolClicked(e, colIndex, rowIndex));
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    /**
     * Sets the pizzaiolo's visual inventory depending on the level's pizzaiolo's hand state
     * @since 2.0
     */
    private void setInventory() {
        if (!this.level.getPizzaiolo().getHand().isHandFull()) {
            this.inventoryGrid.getChildren().clear();
        } else {
            if (this.level.getPizzaiolo().getHand().isIngredient()) {
                ImageView imageView = new ImageView(this.level.getPizzaiolo().getHand().getIngredient().getImagePath());
                inventoryGrid.add(imageView, 0, 0);
            } else {
                Iterator<Ingredient> dishIterator = this.level.getPizzaiolo().getHand().getDish().getListIngredient().iterator();
                this.generateListIngredientsView(dishIterator, inventoryGrid, 82);
            }
        }
    }

    /**
     * Change the pizzaiolo's destination on click
     * @param e the mouseClick
     * @param posX the Table's X axis
     * @param posY the Table's Y axis
     * @since 1.0
     */
    @FXML
    private void tileClicked(MouseEvent e, int posX, int posY) {
        Node source = (Node)e.getSource() ;
        this.clickPosX = source.localToScene(source.getBoundsInLocal()).getCenterX();
        this.clickPosY = source.localToScene(source.getBoundsInLocal()).getCenterY();
        this.clickTileX = posX;
        this.clickTileY = posY;
    }

    /**
     * Make the pizzaiolo use a tool on click
     * @param e the mouseClick
     * @param posX X axis pos of the tool
     * @param posY Y axis pos of the tool
     * @since 1.0
     */
    @FXML
    private void toolClicked(MouseEvent e, int posX, int posY) {
        if (this.level.getTable().get(posX).get(posY) instanceof IngredientTool) {
            this.level.getPizzaiolo().useIngredientTool((IngredientTool) this.level.getTable().get(posX).get(posY));
            //System.out.println(this.level.getPizzaiolo().getHand().toString()+ " ingredient");
        } else {
            this.level.getPizzaiolo().useDishTool((DishTool) this.level.getTable().get(posX).get(posY));
            //System.out.println(this.level.getPizzaiolo().getHand().toString() + " dish");
        }
        this.setInventory();
    }

    /**
     * Sets the visual part of the order depending on the level's order's list
     * @since 2.0
     */
    public void setOrders() {
        this.custommerGrid.getChildren().clear();
        if (this.level.getCustommers().size() != 0) {
            GridPane customer;
            Label waitingTime;
            int customerIndex = 0;
            GridPane customerOrder;
            for (Order order: this.level.getCustommers()) {
                customer = new GridPane();
                waitingTime = new Label("Waiting time : " + Math.round(order.getTime() * 10.0)/10.0 + " s");
                waitingTime.setFont(Font.font (20));
                customer.add(waitingTime, 0, 0);
                customerOrder = new GridPane();
                this.generateListIngredientsView(order.getRecipe().getListIngredient().iterator(), customerOrder, 50);
                customer.add(customerOrder, 0, 1);
                this.custommerGrid.add(customer, 0, customerIndex);

                customerIndex++;
            }
        } else {
            this.custommerGrid.getChildren().clear();
        }
    }

    /**
     *  Generates a visual list of ingredients for the inventory or order list
     * @param ingredientIterator list of ingredients
     * @param gridPane pane to set the list in
     * @param size size of a Ingredient
     * @since 2.0
     */
    private void generateListIngredientsView(Iterator<Ingredient> ingredientIterator, GridPane gridPane, int size) {
        int column = 0;
        int row = 0;
        int imageNumberOnALine = 328/size;
        while (ingredientIterator.hasNext()) {
            ImageView imageView = new ImageView(ingredientIterator.next().getImagePath());
            imageView.setFitHeight(size);
            imageView.setFitWidth(size);
            gridPane.add(imageView, column, row);
            column ++;
            if (column == imageNumberOnALine) {
                row++;
                column = 0;
            }
        }
    }

    /**
     * Checks if a delivered dish is matching with a order
     * @since 2.0
     */
    private void checkDelivery() {
        for (int dishIndex = 0; dishIndex < this.level.getDelivery().getPreparedDishes().size(); dishIndex++) {
            for (int orderIndex = 0; orderIndex < this.level.getCustommers().size(); orderIndex++) {
                if (this.level.getCustommers().size() > orderIndex) {
                    if (this.level.getCustommers().get(orderIndex).getRecipe().isDishMatching(this.level.getDelivery().getPreparedDishes().get(dishIndex))) {
                        this.level.addScore(this.level.getCustommers().get(orderIndex).getPrice());
                        this.level.getCustommers().remove(orderIndex);
                        this.level.getDelivery().getPreparedDishes().remove(this.level.getDelivery().getPreparedDishes().get(dishIndex));
                    }
                }
            }
        }
    }

    /**
     *
     * @return returns the State of the dish in the oven or fresh if none
     * @since 2.0
     */
    private StateDish checkIfDishInOvenIsCooked() {
        Dish dish =  ((DishTool) this.level.getTable().get(1).get(0)).getDish();
        if (dish != null) {
            return dish.getStateDish();
        } else {
            return StateDish.RAW;
        }
    }
}
