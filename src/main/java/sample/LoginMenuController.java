package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import user.ConnectedUser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller of the view LoginMenu.fxml
 *
 * @author Pierre
 * @since 1.0
 * @version 2.0
 */
public class LoginMenuController implements Initializable {


    @FXML
    public Button loginSignIn;
    @FXML
    public Button changeLoginSignInButton;
    @FXML
    public Button goBack;
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Text password;
    @FXML
    private Text username;

    private boolean logIn;


    /**
     * Method that is used at the launch of this controller
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //An if statement should be preferable
        switch (Main.user.getLang()) {
            case "fr_game" -> {
                this.loginSignIn.setText("SE CONNECTER");
                this.changeLoginSignInButton.setText("Pas de compte ? S'inscrire");
                this.username.setText("Nom d'utilisateur");
                this.password.setText("Mot de passe");
            }
            default -> {
                this.loginSignIn.setText("LOG IN");
                this.changeLoginSignInButton.setText("No account ? Sign in");
                this.username.setText("Username");
                this.password.setText("Password");
            }
        }
        this.logIn = true;
    }

    /**
     * Allow to change view between log in and sign in
     *
     * @param mouseEvent
     *
     * @author Yohann
     * @version 1.0
     */
    @FXML
    public void changeLoginSignIn(MouseEvent mouseEvent) {
        if (this.logIn) {
            if(Main.user.getLang()=="en_game"){
                loginSignIn.setText("SIGN IN");
                changeLoginSignInButton.setText("Already signed in ? Log in");
            }else if(Main.user.getLang()=="fr_game"){
                loginSignIn.setText("S'INSCRIRE");
                changeLoginSignInButton.setText("Déjà  inscrit ? Se connecter");
            }
            this.logIn = false;
        } else {
            if(Main.user.getLang()=="en_game"){
                loginSignIn.setText("LOG IN");
                changeLoginSignInButton.setText("No account ? Sign in");
            }else if(Main.user.getLang()=="fr_game"){
                loginSignIn.setText("SE CONNECTER");
                changeLoginSignInButton.setText("Pas de compte ? S'inscrire");
            }
            this.logIn = true;
        }
    }

    /**
     * Allow to log in or sign in, through the database
     *
     * @param mouseEvent
     * @see user.User
     *
     * @author Yohann
     * @since 1.0
     * @author Pierre
     * @since 2.0
     * @version 2.0
     */
    @FXML
    public void login(MouseEvent mouseEvent) throws IOException {
        if(!logIn){
            //créer compte
            Main.user.addUser(userText.getText(), passwordText.getText());
            ConnectedUser newUser = Main.user.connectUser(userText.getText(), passwordText.getText());
            Main.user = newUser;
            URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            goBack.getScene().setRoot(root);
        } else {
            //connexion
            Main.user = Main.user.connectUser(userText.getText(), passwordText.getText());
            URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            goBack.getScene().setRoot(root);
        }
    }

    /**
     * Allow to go back at the main menu.
     * Used on other controllers
     *
     * @param mouseEvent
     * @throws IOException
     *
     * @author Pierre
     */
    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBack.getScene().setRoot(root);
        //SettingsSelectLanguageController.self.checkCurrentLang();
    }
}
