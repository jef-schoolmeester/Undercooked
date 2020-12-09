package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginMenuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected Button loginSignIn;
    @FXML
    protected Button changeLoginSignInButton;
    @FXML
    public Button back;

    public void changeLoginSignIn(javafx.scene.input.MouseEvent mouseEvent) {
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

    public void login(javafx.scene.input.MouseEvent mouseEvent) {
        if(loginSignIn.getText().equals("Sign in")){
            //créer compte
        }
        else if(loginSignIn.getText().equals("Log in")){
            //connexion
        }
    }

    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        URL url = new File("src/main/java/sample/Controller.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }
}
