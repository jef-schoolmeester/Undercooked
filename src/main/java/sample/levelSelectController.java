package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import level.Difficulty;
import level.Level;
import level.recipe.Ingredient;
import level.recipe.Recipe;
import level.recipe.StateIngredient;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Controller of the view levelSelect.fxml
 *
 * @author Pierre
 * @version 1.0
 */
public class levelSelectController {

    @FXML
    private Button goBackButton;

    @FXML
    private GridPane levelGrid;

    @FXML
    public Label usernameLabel;

    /**
     * Allow to go back at the main menu.
     * Used on other controllers
     * @see LoginMenuController
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        URL url = new File("src/main/java/sample/mainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBackButton.getScene().setRoot(root);
    }

    public void initialize() {

        Ingredient tomatosauce = new Ingredient("tomatoSauce", "none");
        Ingredient cream = new Ingredient("cream", "none");
        Ingredient dough = new Ingredient("dough", StateIngredient.PREPARED, "pizzaRoll");
        Ingredient emmental = new Ingredient("emmental", StateIngredient.PREPARED, "grater");
        Ingredient ham = new Ingredient("ham", StateIngredient.PREPARED, "knife");
        Ingredient onion = new Ingredient("onion", StateIngredient.PREPARED, "knife");
        Ingredient shroom = new Ingredient("shroom", StateIngredient.PREPARED, "knife");

        Recipe margarita = new Recipe(new ArrayList<>() {
            {
                add(dough);
                add(tomatosauce);
            }
        });
        Recipe rene = new Recipe(new ArrayList<>() {
            {
                add(dough);
                add(tomatosauce);
                add(ham);
            }
        });
        Recipe royale = new Recipe(new ArrayList<>() {
            {
                add(dough);
                add(tomatosauce);
                add(ham);
                add(shroom);
                add(emmental);
            }
        });
        Recipe carbonara = new Recipe(new ArrayList<>() {
            {
                add(dough);
                add(cream);
                add(ham);
                add(onion);
                add(emmental);
            }
        });
        Recipe undercooked = new Recipe(new ArrayList<>() {
            {
                add(dough);
                add(tomatosauce);
                add(ham);
                add(onion);
                add(shroom);
                add(emmental);
            }
        });

        ArrayList<Recipe> recipes = new ArrayList<>(){
            {
                add(margarita);
            }
        };


        int rowIndex = 0;
        int colIndex = 0;
        for (Difficulty difficulty : Difficulty.values()) {
            switch (difficulty) {
                case NORMAL -> recipes.add(rene);
                case HARD -> recipes.add(royale);
                case VERY_HARD -> recipes.add(carbonara);
                case INSANE -> recipes.add(undercooked);
                default -> {

                }
            }
            addLevel(difficulty, new ArrayList<>(recipes), colIndex, rowIndex);
            colIndex++;
            if (colIndex == 4) {
                colIndex = 0;
                rowIndex++;
            }

        }
        usernameLabel.setText(Main.user.getUserName());
        if (Main.user.getAccess().equals("admin")){
            usernameLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private void levelClicked(Difficulty difficulty, ArrayList<Recipe> recipes) throws Exception {
        Main.level = new Level(difficulty, recipes);
        URL url = new File("src/main/java/sample/level/level.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        goBackButton.getScene().setRoot(root);
    }

    private void addLevel(Difficulty difficulty, ArrayList<Recipe> recipes, int column, int row) {
        Button levelButton = new Button(difficulty.toString());
        levelButton.setOnMouseClicked(e -> {
            try {
                levelClicked(difficulty, recipes);
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        });
        levelButton.setPrefWidth(260);
        levelGrid.add(levelButton, column, row);
    }
}
