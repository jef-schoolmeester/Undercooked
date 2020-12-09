package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class mainMenuController {

    public Button playButton;

    public void changeScene(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/levelSelect.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        playButton.getScene().setRoot(root);
    }
}
