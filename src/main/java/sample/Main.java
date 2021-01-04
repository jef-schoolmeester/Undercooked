package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import level.Level;
import user.User;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Main class to launch the game
 *
 * @author Jef
 * @version 2.0
 */
public class Main extends Application {

    protected Stage primaryStage;
    public static Level level;
    static User user;

    /**
     * Main method that launch the game
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        user = new User("en_game");
        this.primaryStage = primaryStage;
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        this.primaryStage.setTitle("Undercooked");
        this.primaryStage.setScene(new Scene(root, 1100, 800));
        this.primaryStage.show();

        music();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method that allow to launch the game Music, and looping it
     */
    MediaPlayer mediaPlayer;
    public void music() {
        String s = "src/main/resources/music.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
    }
}
