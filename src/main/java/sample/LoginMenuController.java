package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import user.ConnectedUser;

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
    @FXML
    public TextField userText;
    @FXML
    public PasswordField passwordText;

    public static Button login_signin;
    public static Button change_login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_signin = loginSignIn;             //Je n'ai pas compris à quoi servaient ces variables si on peut m'aider
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
        if(loginSignIn.getText().equals("SIGN IN")){
            //créer compte
            Main.user.addUser(userText.getText(), passwordText.getText());
            ConnectedUser newUser = Main.user.connectUser(userText.getText(), passwordText.getText());
            Main.user = newUser;
            //Main.user.connectUser(userText.getText(), passwordText.getText());
        }
        else if(loginSignIn.getText().equals("LOG IN")){
            //connexion
            Main.user = Main.user.connectUser(userText.getText(), passwordText.getText());
            System.out.println(Main.user);
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
