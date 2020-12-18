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

import java.io.File;
import java.net.URL;

public class LevelController {

    @FXML
    private GridPane gameGrid;

    @FXML
    private ImageView pizzaiolo;

    private double clicktileX;
    private double clicktileY;

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

    @FXML
    private Label timerValue;

    public AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            try {
                Thread.sleep(25);
                timer -= 0.025;
                timerValue.setText(String.valueOf(Math.round(timer * 10.0)/10.0) + "s");

                isWalking = true;
                if (Math.abs(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() - clicktileX) > 10) {
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() < clicktileX) {
                        pizzaiolo.setTranslateX(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinX() + 10);
                        walkingState = Walking.WALKING_RIGHT;

                    }
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() > clicktileX) {
                        pizzaiolo.setTranslateX(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinX() - 10);
                        walkingState = Walking.WALKING_LEFT;
                    }
                } else if(Math.abs(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() - clicktileY) > 10) {
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() < clicktileY) {
                        pizzaiolo.setTranslateY(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinY() + 10);
                        walkingState = Walking.WALKING_DOWN;
                    }
                    if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() > clicktileY) {
                        pizzaiolo.setTranslateY(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinY() - 10);
                        walkingState = Walking.WALKING_UP;
                    }
                } else {
                    isWalking = false;
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

    public void initialize() {
        int numCols = 9 ;
        int numRows = 9 ;

        for (int i = 0 ; i < numCols ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            gameGrid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < numRows ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            gameGrid.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0 ; i < numCols ; i++) {
            for (int j = 0; j < numRows; j++) {
                if (j == 0) {
                    addVoidTile(i, j, "/IB/floor/void.png");
                } else {
                    addFloorTile(i, j, "/IB/floor/tileFloor.png");
                }
            }
        }

        this.clicktileX = 726.5;
        this.clicktileY = 426.5;
        this.walking = 0;
        this.timer = 181.75;
        animationTimer.start();
    }

    private void addFloorTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        imageView.setOnMouseClicked(e -> {
            mouseClicked(e);
        });
        gameGrid.add(imageView, colIndex, rowIndex);
    }

    private void addVoidTile(int colIndex, int rowIndex, String imagePath) {
        ImageView imageView = new ImageView(imagePath);
        gameGrid.add(imageView, colIndex, rowIndex);
    }


    @FXML
    private void mouseClicked(MouseEvent e) {
        Node source = (Node)e.getSource() ;
        this.clicktileX = source.localToScene(source.getBoundsInLocal()).getCenterX();
        this.clicktileY = source.localToScene(source.getBoundsInLocal()).getCenterY();
    }
}
