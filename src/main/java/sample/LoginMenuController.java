package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginMenuController implements Initializable {

    @FXML
    public Button loginSignIn;
    @FXML
    public Button changeLoginSignInButton;
    @FXML
    public Button goBack;

    public static Button login_signin;
    public static Button change_login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_signin = loginSignIn;
        change_login = changeLoginSignInButton;
    }

    @FXML
    public void changeLoginSignIn(MouseEvent mouseEvent) {
        if (changeLoginSignInButton.getText().equals("No account ? Sign in")
                || changeLoginSignInButton.getText().equals("Pas de compte ? S'inscrire")) {
            if(mainMenuController.static_user.getLang()=="en_name"){
                loginSignIn.setText("SIGN IN");
                changeLoginSignInButton.setText("Already signed in ? Log in");
            }else if(mainMenuController.static_user.getLang()=="fr_name"){
                loginSignIn.setText("S'INSCRIRE");
                changeLoginSignInButton.setText("Déjà  inscrit ? Se connecter");
            }
        } else {
            if(mainMenuController.static_user.getLang()=="en_name"){
                loginSignIn.setText("LOG IN");
                changeLoginSignInButton.setText("No account ? Sign in");
            }else if(mainMenuController.static_user.getLang()=="fr_name"){
                loginSignIn.setText("SE CONNECTER");
                changeLoginSignInButton.setText("Pas de compte ? S'inscrire");
            }
        }
    }

    @FXML
    public void login(MouseEvent mouseEvent) {
        if(loginSignIn.getText().equals("Sign in")){
            //créer compte
        }
        else if(loginSignIn.getText().equals("Log in")){
            //connexion
        }
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBack.getScene().setRoot(root);
        SettingsSelectLanguageController.self.checkCurrentLang();
    }
}
