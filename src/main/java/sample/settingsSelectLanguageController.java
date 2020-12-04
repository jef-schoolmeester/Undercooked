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

public class settingsSelectLanguageController implements Initializable {

    @FXML
    public Button languageButton;
    @FXML
    public Button addLanguageButton;
    @FXML
    public Button addRecipeButton;
    @FXML
    public Button difficultyButton;

    public static settingsSelectLanguageController self;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        self = this;
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

    public void changeToDifficulty(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsDifficulty.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        difficultyButton.getScene().setRoot(root);
    }
}
