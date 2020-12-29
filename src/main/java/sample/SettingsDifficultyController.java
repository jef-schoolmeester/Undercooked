package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsDifficultyController implements Initializable {

    @FXML
    public AnchorPane rootPane;
    @FXML
    public Button languageButton;
    @FXML
    public Button addLanguageButton;
    @FXML
    public Button addRecipeButton;
    @FXML
    public Button difficultyButton;
    @FXML
    public Button goBack;

    //Initialization static buttons
    public static Button static_lang;
    public static Button static_addLang;
    public static Button static_addRecipe;
    public static Button static_difficulty;
    public static Button static_back;

    public static SettingsDifficultyController self;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        self = this;
        static_lang = languageButton;
        static_addLang = addLanguageButton;
        static_addRecipe = addRecipeButton;
        static_difficulty = difficultyButton;
        static_back = goBack;
    }

    @FXML
    public void changeToLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsSelectLanguage.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        SettingsSelectLanguageController.self.checkCurrentLang();
    }

    @FXML
    public void changeToAddLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddLanguage.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        SettingsSelectLanguageController.self.checkCurrentLang();
    }

    @FXML
    public void changeToAddRecipe(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddRecipe.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        SettingsSelectLanguageController.self.checkCurrentLang();
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBack.getScene().setRoot(root);
        SettingsSelectLanguageController.self.checkCurrentLang();
    }
}
