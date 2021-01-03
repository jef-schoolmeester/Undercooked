package level;

import level.customer.Order;
import level.pizzaiolo.Pizzaiolo;
import level.recipe.Ingredient;
import level.recipe.Recipe;
import level.threads.CustommerThread;
import level.tools.*;


import java.util.ArrayList;
import java.util.Iterator;

/**
 *  This class is the class that regroups all the classes required for a level to work
 *  It is composed of a Table of Tiles
 *  This class also contains all the orders and the possible recipes
 *  The level's ArrayList of order is managed by the CustomerThread Class
 *  It has a difficulty setting, a score, a Pizzaiolo to follow the User's actions
 * @see Difficulty
 * @see Tile
 * @see Pizzaiolo
 * @see Order
 * @see CustommerThread
 * @see Recipe
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 *
 */
public class Level {
    private final Difficulty difficulty;
    private final ArrayList<ArrayList<Tile>> table;
    private final ArrayList<Recipe> recipes;
    private final Pizzaiolo pizzaiolo;
    private final ArrayList<Order> customers;
    private final CustommerThread custommerThread;
    private double score;

    public static int LEVEL_SIZE = 9;

    /**
     * Class constructor
     * Sets up a level, for now the level's size is always 9
     * @param difficulty the difficulty of the level
     * @param recipes the possible recipes for the level
     * @throws Exception if there is no recipe
     * @since 2.0
     */
    public Level(Difficulty difficulty, ArrayList<Recipe> recipes) throws Exception{
        //Set up parameters
        this.difficulty = difficulty;
        this.customers = new ArrayList<>();
        this.table = new ArrayList<>();
        this.score = 0;
        pizzaiolo = new Pizzaiolo(4,4);
        if (recipes.size() == 0) {
            throw new Exception("At least 1 recipe is required");
        }
        this.recipes = recipes;
        Iterator<Recipe> recipeIterator = this.recipes.iterator();
        ArrayList<Ingredient> ingredients = new ArrayList<>(LEVEL_SIZE);
        ArrayList<String> tools = new ArrayList<>();

        //Get all the ingredients from the different recipes and their required tool
        while(recipeIterator.hasNext()) {
            for (Ingredient ingredient : (recipeIterator.next()).getListIngredient()) {
                if (!ingredients.contains(ingredient.getRawIngredient())) {
                    ingredients.add(ingredient.getRawIngredient());
                    System.out.println(ingredient.getRawIngredient().toString());
                    if (!tools.contains(ingredient.getRequiredTool()) && !ingredient.getRequiredTool().equals("none")) {
                        tools.add(ingredient.getRequiredTool());
                    }
                }
            }
        }


        //Generate the base table
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

        //Fill the table with Tiles and void Tiles in the corners
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


        //Set up mandatory tools
        table.get(1).set(0, new Oven(1,0));
        table.get(2).set(0, new Workplan(2,0));
        table.get(3).set(0, new TrashCan(3,0));
        table.get(4).set(0, new Delivery(4,0));



        //Set up optional tools
        Iterator<String> toolsIterator = tools.iterator();
        int counter = 5;
        while (toolsIterator.hasNext() && counter <= 7) {
            System.out.println(counter);
            switch (toolsIterator.next()) {
                case "grater" -> table.get(counter).set(0, new Grater(counter, 0));
                case "knife" -> table.get(counter).set(0, new Knife(counter, 0));
                case "pizzaRoll" -> table.get(counter).set(0, new PizzaRoll(counter, 0));
                default -> table.get(counter).set(0, new VoidTile(counter, 0));
            }
            counter++;
        }

        //Set up ingredient containers
        Iterator<Ingredient> ingredientIterator = ingredients.iterator();
        int rowCounter = 1;
        int colCounter = 0;
        while (ingredientIterator.hasNext() && !(rowCounter == 1 && colCounter == 8)) {
            table.get(colCounter).set(rowCounter, new IngredientContainer(colCounter, rowCounter, ingredientIterator.next()));
            if (rowCounter < 7 && colCounter == 0) {
                rowCounter ++;
            } else {
                if (colCounter < 7) {
                    rowCounter = 8;
                    colCounter++;
                } else {
                    colCounter = 8;
                    rowCounter--;
                }
            }
        }

        this.custommerThread = new CustommerThread(this);
        this.custommerThread.start();
    }

    /**
     * Prints the current level in the console
     * <i>Only for dev uses</i>
     * @since 1.0
     */
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

    /**
     * Prints the current orders in the console
     * <i>Only for dev uses</i>
     * @since 1.0
     */
    public void printCustomers() {
        for (Order order: this.customers) {
            System.out.println(order.getRecipe().toString());
        }
    }

    /**
     * Sets the pizzaiolo to a specific position
     * @param x X axis position
     * @param y Y axis position
     * @throws IndexOutOfBoundsException if the pizzaiolo is out of the table bounds
     * <i>Never used</i>
     * @since 1.0
     */
    public void setPizzaioloPos(int x, int y) throws IndexOutOfBoundsException {
        if (x >= LEVEL_SIZE || y >= LEVEL_SIZE) {
            throw new IndexOutOfBoundsException("Pos out of bounds");
        }
        this.pizzaiolo.setPos(x, y);
    }

    /**
     *
     * @return the current Pizzaiolo
     * @since 1.0
     */
    public Pizzaiolo getPizzaiolo() {
        return this.pizzaiolo;
    }

    /**
     *
     * @return the current table
     * @since 1.0
     */
    public ArrayList<ArrayList<Tile>> getTable() {
        return table;
    }

    /**
     *
     * @return the Difficulty parameter
     * @since 1.0
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     *
     * @return the current customer's list
     * @since 1.0
     */
    public ArrayList<Order> getCustommers() {
        return customers;
    }

    /**
     *
     * @return the possible recipe's list
     * @since 1.0
     */
    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    /**
     *
     * @return the current score
     * @since 2.0
     */
    public double getScore() {
        return this.score;
    }

    /**
     * Add score to the current score
     * @param score to be added to the current score
     * @since 2.0
     */
    public void addScore(double score) {
        this.score+= score;
    }

    /**
     *
     * @return returns the delivery Tool
     * <i>Not a general method</i>
     * @since 2.0
     */
    public Delivery getDelivery() {
        return (Delivery) this.table.get(4).get(0);
    }

    /**
     * Stops the Level's managers : CustomerThread managing the orders and OvenThread managing the oven
     * @since 2.0
     */
    public void stop() {
        this.custommerThread.stopRunning();
        ((Oven) this.table.get(1).get(0)).stopThread();
    }
}