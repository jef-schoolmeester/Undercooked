package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import level.Level;
import user.User;

import java.io.File;
import java.net.URL;

/**
 * Main class to launch the game
 *
 * @author Jef
 * @version 2.0
 */
public class Main extends Application {

    protected Stage primaryStage;
    public static Level level;
    static User user = new User();

    /**
     * Main method that launch the game
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        this.primaryStage.setTitle("Undercooked");
        this.primaryStage.setScene(new Scene(root, 1100, 800));

        this.primaryStage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
