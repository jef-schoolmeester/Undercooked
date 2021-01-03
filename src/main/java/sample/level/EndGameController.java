package sample.level;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Controller of the postGame view
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class EndGameController {

    @FXML
    private Button back;

    @FXML
    private Label gameScore;

    /**
     * Sets the score of the previous level
     * @since 1.0
     */
    public void initialize() {
        this.gameScore.setText(Math.round(Main.level.getScore()*10.0)/10.0 + " €");
    }

    /**
     * Goes to the levelSelect menu
     * @param mouseEvent mouseClick
     * @throws IOException
     * @since 1.0
     */
    public void back(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/levelSelect.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }

    /**
     * Goes back to the main menu
     * @param mouseEvent mouseClick
     * @throws IOException
     * @since 1.0
     */
    public void mainMenu(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }
}
