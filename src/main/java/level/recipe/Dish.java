package level.recipe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Dish is the delivered object to the customers(Order)
 * This class is composed from a ArraysList of ingredients and a state
 * @see level.customer.Order
 * @see Ingredient
 * @see StateDish
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class Dish {

    private ArrayList<Ingredient> listIngredient;
    private StateDish stateDish;

    /**
     * Class constructor
     * Creates a raw empty dish
     */
    public Dish() {
        this.listIngredient = new ArrayList<>();
        this.stateDish = StateDish.RAW;
    }

    /**
     * Class constructor
     * Creates a raw dish with a base ingredient
     * @param ingredient the first ingredient of the dish
     * @since 1.0
     */
    public Dish(Ingredient ingredient) {
        this.listIngredient = new ArrayList<>();
        this.listIngredient.add(ingredient);
        this.stateDish = StateDish.RAW;
        this.checkCurrentState();
    }

    /**
     * Adds a ingredient to the dish
     * @param ingredient the ingredient added.
     * @since 1.0
     */
    public void addIngredient(Ingredient ingredient) {
        this.listIngredient.add(ingredient);
        this.checkCurrentState();
    }

    /**
     *
     * @return the current state of the dish
     * @see StateDish
     * @since 1.0
     */
    public StateDish getStateDish() {
        return this.stateDish;
    }

    /**
     * Sets the state parameter of the dish
     * @param stateDish the state to set
     * @since 1.0
     */
    public void setStateDish(StateDish stateDish) {
        this.stateDish = stateDish;
    }

    /**
     *
     * @return the current list of ingredients
     * @since 1.0
     */
    public ArrayList<Ingredient> getListIngredient() {
        return this.listIngredient;
    }


    /**
     * Checks if one of the ingredients in the dish is trash
     * If one of the ingredients is trash, sets the whole dish as trash
     * @since 1.0
     */
    public void checkCurrentState() {
        if (this.stateDish != StateDish.TRASH) {
            boolean isTrash = false;
            Iterator<Ingredient> iterator = this.listIngredient.iterator();
            while (iterator.hasNext() && !isTrash) {
                if (iterator.next().getState() == StateIngredient.TRASH) {
                    isTrash = true;
                }
            }
            if (isTrash) {
                this.setStateDish(StateDish.TRASH);
            }
        }
    }

    /**
     * Generates a String representing the dish's current state
     * @return the generated String
     * @since 2.0
     */
    public String toString() {
        String value = this.stateDish.toString() + " ";
        for (Ingredient i: listIngredient) {
            value += i.toString() + " ";
        }
        return value;
    }

}
