package level;

import level.recipe.Ingredient;
import level.recipe.Recipe;
import level.tools.Hatch;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws Exception {


        ArrayList<Recipe> recipes = new ArrayList<>();
        Ingredient dough = new Ingredient("Dough", "pizzaRoll");
        Ingredient tomatoSauce = new Ingredient("TomatoSauce", "none");
        recipes.add(new Recipe(new ArrayList<>() {
            {
                add(dough);
                add(tomatoSauce);
            }
        }));
        Level level = new Level(Difficulty.EASY, recipes);
        /*try {
            Level level = new Level(Difficulty.EASY, recipes);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}
