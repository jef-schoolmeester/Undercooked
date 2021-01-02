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

    public static SettingsAddLanguageController self;

    /**
     * @see Initializable
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        self = this;
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
    }

}
