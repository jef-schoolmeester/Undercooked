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
        Iterator<Recipe> recipeIterator = this.recipes.iterator();
        ArrayList<Ingredient> ingredients = new ArrayList<>(LEVEL_SIZE);
        ArrayList<String> tools = new ArrayList<>();

        while(recipeIterator.hasNext()) {
            Iterator<Ingredient> ingredientIterator = (recipeIterator.next()).getListIngredient().iterator();
            while (ingredientIterator.hasNext()) {
                Ingredient ingredient = ingredientIterator.next();
                if (!ingredients.contains(ingredient.getRawIngredient())) {
                    ingredients.add(ingredient.getRawIngredient());
                    if (!tools.contains(ingredient.getRequiredTool())) {
                        tools.add(ingredient.getRequiredTool());
                    }
                }
            }
        }
        //Better version
        /*while(recipeIterator.hasNext()) {
            for (Ingredient ingredient : (recipeIterator.next()).getListIngredient()) {
                if (!ingredients.contains(ingredient.getRawIngredient())) {
                    ingredients.add(ingredient.getRawIngredient());
                    if (!tools.contains(ingredient.getRequiredTool())) {
                        tools.add(ingredient.getRequiredTool());
                    }
                }
            }
        }*/


        for (int i = 0; i < LEVEL_SIZE; i++) {
            table.add(new ArrayList<>() {
                {
                    for (int i = 0; i < LEVEL_SIZE; i++) {
                        if (i == 0) {
                            add(new VoidTile(i, i));
                        } else {
                            add(new Tile(i, i));
                        }
                    }
                }
            });
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


        table.get(1).set(0, new Oven(1,0));
        table.get(2).set(0, new Workplan(2,0));
        table.get(3).set(0, new Delivery(3,0));
        table.get(4).set(0, new TrashCan(4,0));
        table.get(5).set(0, new PizzaRoll(5,0));



        Iterator<String> toolsIterator = tools.iterator();
        int counter = 5;
        while (toolsIterator.hasNext() && counter < 7) {
            System.out.println(counter);
            switch (toolsIterator.next()) {
                case "grater" -> table.get(counter).set(0, new Grater(counter, 0));
                case "knife" -> table.get(counter).set(0, new Knife(counter, 0));
                case "pizzaRoll" -> table.get(counter).set(0, new PizzaRoll(counter, 0));
                default -> table.get(counter).set(0, new VoidTile(counter, 0));
            }
            counter++;
        }


        //Browse all recipes
        //For each recipe, get all ingredients
        //For each ingredient, get ingredient container + required tool
        for (int i = 0; i < LEVEL_SIZE; i++) {
            for (int j = 0; j < LEVEL_SIZE; j++) {
                System.out.print(table.get(j).get(i).toString());
                System.out.print(" | ");
            }
            System.out.println();
        }
    }




}