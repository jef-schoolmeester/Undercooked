package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class levelSelectController {
    public Button goBackButton;

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void changeScene(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBackButton.getScene().setRoot(root);
    }
}
