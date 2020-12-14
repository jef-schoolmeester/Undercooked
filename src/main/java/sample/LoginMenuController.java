package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import user.ConnectedUser;
import user.UnconnectedUser;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginMenuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

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

    @FXML
    public void changeLoginSignIn(MouseEvent mouseEvent) {
        if (changeLoginSignInButton.getText().equals("No account ? Sign in")) {
            loginSignIn.setText("SIGN IN");
            changeLoginSignInButton.setText("Already signed in ? Log in");
            System.out.println("yes");
        } else {
            loginSignIn.setText("LOG IN");
            changeLoginSignInButton.setText("No account ? Sign in");
            System.out.println("NO");
        }

    }

    @FXML
    public void login(MouseEvent mouseEvent) {
        if(loginSignIn.getText().equals("SIGN IN")){
            //créer compte
            ((UnconnectedUser) Main.user).addUser(userText.getText(), passwordText.getText());
            Main.user = new ConnectedUser(userText.getText());
        }
        else if(loginSignIn.getText().equals("LOG IN")){
            //connexion
       //     ((UnconnectedUser) Main.user).connectUser(userText.getText(), passwordText.getText());
       //     Main.user = ((UnconnectedUser) Main.user).connectUser(userText.getText(), passwordText.getText());
        }
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBack.getScene().setRoot(root);
    }

}
