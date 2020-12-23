package level;

import level.pizzaiolo.Pizzaiolo;
import level.recipe.Ingredient;
import level.recipe.Recipe;
import level.tools.*;


import javax.tools.Tool;
import java.util.ArrayList;
import java.util.Iterator;

public class Level {
    private Difficulty difficulty;
    private ArrayList<ArrayList<Tile>> table;
    private ArrayList<Recipe> recipes;
    private Pizzaiolo pizzaiolo;

    private ArrayList<IngredientContainer> ingredientContainers;

    public static int LEVEL_SIZE = 9;

    public Level(Difficulty difficulty, ArrayList<Recipe> recipes) throws Exception{
        this.difficulty=difficulty;
        this.table = new ArrayList<>();
        pizzaiolo = new Pizzaiolo();
        if (recipes.size() == 0) {
            throw new Exception("At least 1 recipe is required");
        }
        this.recipes = recipes;
        Iterator recipeIterator = this.recipes.iterator();
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ArrayList<String> tools = new ArrayList<>();

        while(recipeIterator.hasNext()) {
            Iterator ingredientIterator = ((Recipe) recipeIterator.next()).getListIngredient().iterator();
            while (ingredientIterator.hasNext()) {
                Ingredient ingredient = (Ingredient) ingredientIterator.next();
                if (!ingredients.contains(ingredient.getRawIngredient())) {
                    ingredients.add(ingredient.getRawIngredient());
                    if (!tools.contains(ingredient.getRequiredTool())) {
                        tools.add(ingredient.getRequiredTool());
                    }
                }
            }
        }


        for (int i = 0; i < LEVEL_SIZE; i++) {
            for (int j = 0; j < LEVEL_SIZE; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 8) || (i == 8 && j == 0) || (i == 8 && j == 8)) {
                    table.get(i).set(j, new VoidTile(i, j));
                } else {
                    if (i > 0 && j > 0 && i < 8 && j < 8) {
                        table.get(i).set(j, new Tile(i, j));
                    }
                }
            }
        }

        //Browse all recipes
        //For each recipe, get all ingredients
        //For each ingredient, get ingredient container + required tool
    }




}