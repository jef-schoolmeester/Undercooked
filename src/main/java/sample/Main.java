package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import level.Level;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    protected Stage primaryStage;
    public static Level level;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        URL url = new File("src/main/java/sample/level/level.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        this.primaryStage.setTitle("Undercooked");
        this.primaryStage.setScene(new Scene(root, 1100, 800));
        this.primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
