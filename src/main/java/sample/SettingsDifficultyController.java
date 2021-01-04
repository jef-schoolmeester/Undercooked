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

/**
 * Controller of the view settingsDifficulty.fxml
 *
 * @author Pierre
 * @version 1.0
 */
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


    /**
     * @see Initializable
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SettingsAddLanguageController.checkLanguage(this.addLanguageButton, this.addRecipeButton, this.difficultyButton, this.languageButton);
    }

    /**
     * @see SettingsAddLanguageController#changeToLanguage(MouseEvent) 
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void changeToLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsSelectLanguage.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }

    /**
     * @see SettingsSelectLanguageController#changeToAddLanguage(MouseEvent) 
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void changeToAddLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddLanguage.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }

    /**
     * @see SettingsSelectLanguageController#changeToAddRecipe(MouseEvent) 
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void changeToAddRecipe(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddRecipe.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }

    /**
     * @see LoginMenuController#goBack(MouseEvent) 
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBack.getScene().setRoot(root);
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }
}
