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

public class SettingsSelectLanguageController implements Initializable {

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
    @FXML
    public Button francais;
    @FXML
    public Button english;

    public static SettingsSelectLanguageController self;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        self = this;
    }

    // Première méthode, ne fonctionne pas, need help je comprends pas
    @FXML
    public void changeToAddLanguage(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddLanguage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        addLanguageButton.getScene().setRoot(root);
        checkCurrentLang();
    }

    // Deuxième méthode, ne fonctionne pas non plus, need help je comprends pas
    @FXML
    public void changeToAddRecipe(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsAddRecipe.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        checkCurrentLang();
    }

    @FXML
    public void changeToDifficulty(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/settingsDifficulty.fxml").toURI().toURL();
        AnchorPane pane = FXMLLoader.load(url);
        rootPane.getChildren().setAll(pane);
        checkCurrentLang();
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBack.getScene().setRoot(root);
        checkCurrentLang();
    }

    public void french(MouseEvent mouseEvent) throws IOException {
        mainMenuController.static_user.setLang("fr_name");
        checkCurrentLang();
    }

    public void english(MouseEvent mouseEvent) throws IOException {
        mainMenuController.static_user.setLang("en_name");
        checkCurrentLang();
    }

    public void checkCurrentLang(){
        if(mainMenuController.static_user.getLang()=="en_name"){

            mainMenuController.settings_button.setText("SETTINGS");
            mainMenuController.play_button.setText("PLAY");
            mainMenuController.login_Button.setText("LOGIN");

            languageButton.setText("Language");
            difficultyButton.setText("Difficulty");
            addRecipeButton.setText("Add recipe");
            addLanguageButton.setText("Add language");

            SettingsAddLanguageController.static_lang.setText("Language");
            SettingsAddLanguageController.static_difficulty.setText("Difficulty");
            SettingsAddLanguageController.static_addRecipe.setText("Add recipe");
            SettingsAddLanguageController.static_addLang.setText("Add language");

            SettingsAddRecipeController.static_lang.setText("Language");
            SettingsAddRecipeController.static_difficulty.setText("Difficulty");
            SettingsAddRecipeController.static_addRecipe.setText("Add recipe");
            SettingsAddRecipeController.static_addLang.setText("Add language");

            SettingsDifficultyController.static_lang.setText("Language");
            SettingsDifficultyController.static_difficulty.setText("Difficulty");
            SettingsDifficultyController.static_addRecipe.setText("Add recipe");
            SettingsDifficultyController.static_addLang.setText("Add language");

            LoginMenuController.login_signin.setText("LOG IN");
            LoginMenuController.change_login.setText("No account ? Sign in");

        }else if (mainMenuController.static_user.getLang()=="fr_name"){

            mainMenuController.play_button.setText("JOUER");
            mainMenuController.login_Button.setText("SE CONNECTER");
            mainMenuController.settings_button.setText("PARAMETRES");

            languageButton.setText("Langue");
            difficultyButton.setText("Difficulté");
            addRecipeButton.setText("Ajouter recette");
            addLanguageButton.setText("Ajouter langue");

            SettingsAddLanguageController.static_lang.setText("Langue");
            SettingsAddLanguageController.static_difficulty.setText("Difficulté");
            SettingsAddLanguageController.static_addRecipe.setText("Ajouter recette");
            SettingsAddLanguageController.static_addLang.setText("Ajouter langue");

            SettingsAddRecipeController.static_lang.setText("Langue");
            SettingsAddRecipeController.static_difficulty.setText("Difficulté");
            SettingsAddRecipeController.static_addRecipe.setText("Ajouter recette");
            SettingsAddRecipeController.static_addLang.setText("Ajouter langue");

            SettingsDifficultyController.static_lang.setText("Langue");
            SettingsDifficultyController.static_difficulty.setText("Difficulté");
            SettingsDifficultyController.static_addRecipe.setText("Ajouter recette");
            SettingsDifficultyController.static_addLang.setText("Ajouter langue");

            LoginMenuController.login_signin.setText("SE CONNECTER");
            LoginMenuController.change_login.setText("Pas de compte ? S'inscrire");
        }
    }
}
