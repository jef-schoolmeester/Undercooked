package level.tools;

import level.recipe.Dish;
import level.recipe.Ingredient;

/**
 * Workplan is the class where the pizzaiolo assemmbles ingredients into a dish
 * This class extends Dishtool
 * @see DishTool
 * @see Dish
 * @see Ingredient
 * @see level.pizzaiolo.Pizzaiolo
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class Workplan extends DishTool {

    /**
     * Class constructor
     * @param posX the x axis position
     * @param posY the y axis position
     * @since 1.0
     */
    public Workplan(int posX, int posY) {
        super(posX, posY);
    }

    /**
     *
     * @param ingredient the ingredient to be added to the dish or base ingredient
     * @return true if the operation was successful, false otherwise
     * @since 1.0
     */
    public boolean addIngredient(Ingredient ingredient) {
        if (this.isEmpty()) {
            this.dish = new Dish(ingredient);
        } else {
            this.dish.addIngredient(ingredient);
        }
        return true;
    }

    /**
     *
     * @return the class name as string
     * @since 2.0
     */
    public String toString() {
        return "workplan";
    }

    /**
     *
     * @return the image path to the workPlan
     * @since 2.0
     */
    public String getImagePath() {
        return "/IB/tools/workplan.png";
    }
}