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
 * Controller of the view settingsAddLanguage.fxml
 *
 * @author Pierre
 * @version 1.0
 */
public class SettingsAddLanguageController implements Initializable {

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
        checkLanguage(this.addLanguageButton, this.addRecipeButton, this.difficultyButton, this.languageButton);
    }

    /**
     * Same as LoginMenuController.initialize()
     * @see LoginMenuController#initialize(URL, ResourceBundle)
     *
     * @param addLanguageButton
     * @param addRecipeButton
     * @param difficultyButton
     * @param languageButton
     *
     * @author Yohann
     */
    static void checkLanguage(Button addLanguageButton, Button addRecipeButton, Button difficultyButton, Button languageButton) {
        // An if statement should be preferable
        switch (Main.user.getLang()) {
            case "fr_game" -> {
                addLanguageButton.setText("Ajouter langue");
                addRecipeButton.setText("Ajouter recette");
                difficultyButton.setText("Difficulte");
                languageButton.setText("Langue");
            }
            default -> {
                addLanguageButton.setText("Add Language");
                addRecipeButton.setText("Add recipe");
                difficultyButton.setText("Difficulty");
                languageButton.setText("Language");
            }
        }
    }

    /**
     * Allow to change to Select Language submenu
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
     * @see SettingsSelectLanguageController#changeToDifficulty(MouseEvent)
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void changeToDifficulty(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsDifficulty.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }

    /**
     * Used on other controllers
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
