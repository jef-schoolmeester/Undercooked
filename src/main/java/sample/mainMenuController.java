package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import user.ConnectedUser;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Controller of the view mainMenu.fxml
 *
 * @author Jef
 * @author Pierre
 * @since 2.0
 * @version 2.0
 */
public class mainMenuController {

    @FXML
    public Button playButton;
    @FXML
    public Button settingsButton;
    @FXML
    public Button logInButton;
    @FXML
    public Label usernameLabel;

    /**
     * Allow to change to level select menu
     *
     * @param mouseEvent
     * @throws IOException
     *
     * @author Jef
     */
    @FXML
    public void changeToPlay(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/levelSelect.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        playButton.getScene().setRoot(root);
    }

    /**
     * Allow to change to settings menu
     *
     * @param mouseEvent
     * @throws IOException
     *
     * @author Jef
     */
    @FXML
    public void changeToSettings(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsSelectLanguage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        settingsButton.getScene().setRoot(root);
    }

    /**
     * Allow to change to Log in menu
     *
     * @param mouseEvent
     * @throws IOException
     *
     * @author Jef
     */
    @FXML
    public void changeToLog(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/LoginMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logInButton.getScene().setRoot(root);
    }

    /**
     * Method to display user name on screen, and change color if user access is admin
     *
     * @author Pierre
     */
    @FXML
    public void initialize(){
        usernameLabel.setText(Main.user.getUserName());
        if (Main.user.getAccess().equals("admin")){
            usernameLabel.setStyle("-fx-text-fill: red;");
        }
    }

}
