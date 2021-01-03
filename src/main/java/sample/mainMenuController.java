package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import user.User;
import javafx.scene.text.Text;
import user.ConnectedUser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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
    private Button playButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button logInButton;
    @FXML
    private Label usernameLabel;


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
        //SettingsSelectLanguageController.self.checkCurrentLang();
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
        //SettingsSelectLanguageController.self.checkCurrentLang();
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
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }

    /**
     * Method to display user name on screen, and change color if user access is admin
     *
     * @author Pierre
     */
    @FXML
    public void initialize(){
        switch (Main.user.getLang()) {
            case "fr_game" -> {
                playButton.setText("JOUER");
                logInButton.setText("CONNEXION");
                settingsButton.setText("PARAMETRES");
                usernameLabel.setText("Non connecte");
            }
            default -> {
                playButton.setText("PLAY");
                logInButton.setText("LOG IN");
                settingsButton.setText("SETTINGS");
                usernameLabel.setText("Not connected");
            }

        }

        usernameLabel.setText(Main.user.getUserName());
        if (Main.user.getAccess().equals("admin")){
            usernameLabel.setStyle("-fx-text-fill: red;");
        }
    }

}
