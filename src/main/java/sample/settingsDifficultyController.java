package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class settingsDifficultyController implements Initializable {

    @FXML
    public Button languageButton;
    @FXML
    public Button addLanguageButton;
    @FXML
    public Button addRecipeButton;
    @FXML
    public Button difficultyButton;

    public static settingsDifficultyController self;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        self = this;
    }

    public void changeToLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsSelectLanguage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        languageButton.getScene().setRoot(root);
    }

    public void changeToAddLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddLanguage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        addLanguageButton.getScene().setRoot(root);
    }

    public void changeToAddRecipe(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddRecipe.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        addRecipeButton.getScene().setRoot(root);
    }
}
