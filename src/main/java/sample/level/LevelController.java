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
import level.Level;
import level.recipe.Ingredient;
import level.tools.DishTool;
import level.tools.IngredientTool;
import level.tools.Tile;
import sample.Main;

import javax.tools.Tool;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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
    private Label timerValue;

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

    private double timer;

    private Level level;

    public AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            try {
                Thread.sleep(25);
                timer -= 0.025;
                timerValue.setText(String.valueOf(Math.round(timer * 10.0)/10.0) + "s");

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
                    case WALKING_UP -> {
                        walkingPath = "up";
                    }
                    case WALKING_DOWN -> {
                        walkingPath = "down";
                    }
                    case WALKING_LEFT -> {
                        walkingPath = "left";
                    }
                    case WALKING_RIGHT -> {
                        walkingPath = "right";;
                    }
                    default -> {
                        System.out.println("STAR PLATINUM");
                    }
                }

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
                setInventory();

                if (timer < 0) {
                    URL url = new File("src/main/java/sample/level/endGame.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    timerValue.getScene().setRoot(root);
                    this.stop();
                }


            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    public void initialize() throws Exception {
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
                    case "void" -> addVoidTile(i, j, table.get(i).get(j).imgPath());
                    case "tile" -> addFloorTile(i, j, table.get(i).get(j).imgPath());
                    default -> addToolTile(i, j, table.get(i).get(j).imgPath());
                }
            }
        }

        /*for (int i = 0 ; i < numCols ; i++) {
            for (int j = 0; j < numRows; j++) {
                if (j == 0) {
                    addVoidTile(i, j, "/IB/floor/void.png");
                } else {
                    addFloorTile(i, j, "/IB/floor/tileFloor.png");
                }
            }
        }*/

        this.clickPosX = 726.5;
        this.clickPosY = 426.5;
        this.clickTileX = 4;
        this.clickTileY = 4;
        this.walking = 0;
        this.timer = 181.75;
        animationTimer.start();
        System.out.println(this.level.getPizzaiolo().getHand().getIngredient().toString());
    }

    private void addFloorTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        imageView.setOnMouseClicked(e -> {
            tileClicked(e, colIndex, rowIndex);
        });
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    private void addVoidTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    private void addToolTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        imageView.setOnMouseClicked(e -> {
            toolClicked(e, colIndex, rowIndex);
        });
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    private void setInventory() {
        if (!this.level.getPizzaiolo().getHand().isHandFull()) {
            this.inventoryGrid.getChildren().clear();
        } else {
            if (this.level.getPizzaiolo().getHand().isIngredient()) {
                ImageView imageView = new ImageView(this.level.getPizzaiolo().getHand().getIngredient().getImagePath());
                inventoryGrid.add(imageView, 0, 0);
            } else {
                Iterator<Ingredient> dishIterator = this.level.getPizzaiolo().getHand().getDish().getListIngredient().iterator();
                int column = 0;
                int row = 0;
                while (dishIterator.hasNext()) {
                    ImageView imageView = new ImageView(dishIterator.next().getImagePath());
                    inventoryGrid.add(imageView, column, row);
                    column ++;
                    if (column == 4) {
                        row++;
                        column = 0;
                    }
                }
            }
        }
    }

    private void setCustommers() {

    }

    @FXML
    private void tileClicked(MouseEvent e, int posX, int posY) {
        Node source = (Node)e.getSource() ;
        this.clickPosX = source.localToScene(source.getBoundsInLocal()).getCenterX();
        this.clickPosY = source.localToScene(source.getBoundsInLocal()).getCenterY();
        this.clickTileX = posX;
        this.clickTileY = posY;
    }

    @FXML
    private void toolClicked(MouseEvent e, int posX, int posY) {
        if (this.level.getTable().get(posX).get(posY) instanceof IngredientTool) {
            this.level.getPizzaiolo().useIngredientTool((IngredientTool) this.level.getTable().get(posX).get(posY));
            System.out.println(this.level.getPizzaiolo().getHand().toString()+ " ingredient");
        } else {
            this.level.getPizzaiolo().useDishTool((DishTool) this.level.getTable().get(posX).get(posY));
            System.out.println(this.level.getPizzaiolo().getHand().toString() + " dish");
        }
    }
}
