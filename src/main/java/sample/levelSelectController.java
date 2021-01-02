package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Controller of the view levelSelect.fxml
 *
 * @author Pierre
 * @version 1.0
 */
public class levelSelectController {
    @FXML
    public Button goBackButton;

    /**
     * Allow to go back at the main menu.
     * Used on other controllers
     * @see LoginMenuController
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBackButton.getScene().setRoot(root);
    }
}
