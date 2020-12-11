package sample.level;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.awt.*;

public class levelController {

    @FXML
    private GridPane gameGrid;

    @FXML
    private ImageView pizzaiolo;

    private double clicktileX;
    private double clicktyleY;

    private int walking;
    private boolean isWalking;

    private float timer;

    @FXML
    private Label timerValue;

    public AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            try {
                Thread.sleep(25);
                timer -= 0.025;
                timerValue.setText(String.valueOf((int) timer));
                System.out.println(timer);

                isWalking = false;
                if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() < clicktileX) {
                    pizzaiolo.setTranslateX(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinX() + 10);
                }
                if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() < clicktyleY) {
                    pizzaiolo.setTranslateY(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinY() + 10);
                }
                if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterX() > clicktileX) {
                    pizzaiolo.setTranslateX(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinX() - 10);
                }
                if (pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getCenterY() > clicktyleY) {
                    pizzaiolo.setTranslateY(pizzaiolo.localToScene(pizzaiolo.getBoundsInLocal()).getMinY() - 10);
                }

                if (isWalking) {
                    walking += 1;
                    if (walking > 8) {
                        pizzaiolo.setImage(new Image(getClass().getResourceAsStream("/IB/testSprite3.png")));
                    } else {
                        pizzaiolo.setImage(new Image(getClass().getResourceAsStream("/IB/testSprite2.png")));
                    }
                    if (walking > 12) {
                        walking = 0;
                    }
                } else {
                    pizzaiolo.setImage(new Image(getClass().getResourceAsStream("/IB/testSprite.png")));
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
                addPane(i, j);
            }
        }

        this.clicktileX = 726.5;
        this.clicktyleY = 426.5;
        this.walking = 0;
        this.timer = 180;
        animationTimer.start();
    }

    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            mouseClicked(e);
        });
        gameGrid.add(pane, colIndex, rowIndex);
    }

    @FXML
    private void mouseClicked(MouseEvent e) {
        Node source = (Node)e.getSource() ;
        this.clicktileX = source.localToScene(source.getBoundsInLocal()).getCenterX();
        this.clicktyleY = source.localToScene(source.getBoundsInLocal()).getCenterY();
    }
}
