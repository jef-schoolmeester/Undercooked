package level;

import level.recipe.Recipe;
import level.tools.Hatch;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {


        ArrayList<Recipe> recipes = new ArrayList<>();
        /*try {
            Level level = new Level(Difficulty.EASY, recipes);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Hatch hatch = new Hatch(1, 1);
        System.out.println(hatch.toString());

    }
}
