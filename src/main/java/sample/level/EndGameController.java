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

@SuppressWarnings("ALL")
public class EndGameController {

    @FXML
    public Button back;

    @FXML
    private Label gameScore;

    public void initialize() {
        this.gameScore.setText(Math.round(Main.level.getScore()*10.0)/10.0 + " €");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/levelSelect.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }

    public void mainMenu(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }
}
