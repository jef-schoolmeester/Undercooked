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
    private ArrayList<Recipe> custommers;

    public static int LEVEL_SIZE = 9;

    public Level(Difficulty difficulty, ArrayList<Recipe> recipes) throws Exception{
        this.difficulty = difficulty;
        this.custommers = new ArrayList<>();
        this.table = new ArrayList<>();
        pizzaiolo = new Pizzaiolo(4,4);
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
        table.get(3).set(0, new TrashCan(3,0));
        table.get(4).set(0, new Delivery(4,0));



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

        Iterator<Ingredient> ingredientIterator = ingredients.iterator();
        int rowCounter = 1;
        int colCounter = 0;
        while (ingredientIterator.hasNext() && !(rowCounter == 1 && colCounter == 8)) {
            table.get(colCounter).set(rowCounter, new IngredientContainer(colCounter, rowCounter, ingredientIterator.next()));
            if (rowCounter < 7) {
                rowCounter ++;
            }
        }
    }

    public void printLevel() {
        for (int i = 0; i < LEVEL_SIZE; i++) {
            for (int j = 0; j < LEVEL_SIZE; j++) {
                if (i == this.pizzaiolo.getPosY() && j == this.pizzaiolo.getPosX()) {
                    System.out.print("pizzaiolo");
                    System.out.print(" | ");
                } else {
                    System.out.print(table.get(j).get(i).toString());
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public void setPizzaioloPos(int x, int y) throws IndexOutOfBoundsException {
        if (x >= LEVEL_SIZE || y >= LEVEL_SIZE) {
            throw new IndexOutOfBoundsException("Pos out of bounds");
        }
        this.pizzaiolo.setPos(x, y);
    }

    public Pizzaiolo getPizzaiolo() {
        return this.pizzaiolo;
    }

    public ArrayList<ArrayList<Tile>> getTable() {
        return table;
    }
}