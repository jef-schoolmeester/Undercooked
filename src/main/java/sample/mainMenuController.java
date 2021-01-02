package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import user.ConnectedUser;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class mainMenuController {

    @FXML
    public Button playButton;
    @FXML
    public Button settingsButton;
    @FXML
    public Button logInButton;
    @FXML
    public Label usernameLabel;

    @FXML
    public void changeToPlay(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/levelSelect.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        playButton.getScene().setRoot(root);
    }

    @FXML
    public void changeToSettings(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsSelectLanguage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        settingsButton.getScene().setRoot(root);
    }

    @FXML
    public void changeToLog(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/LoginMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logInButton.getScene().setRoot(root);
    }

    @FXML
    public void initialize(){
        usernameLabel.setText(Main.user.getUserName());
    }

}
