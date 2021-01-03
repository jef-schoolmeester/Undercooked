package level.customer;

import level.recipe.Recipe;
/**
 * Order class
 *
 * Class that defines an order
 *
 * @author Yohann
 * @since 1.0
 * @author Jef
 * @since 2.0
 * @version 2.0
 */
public class Order {

    private final Recipe recipe;
    private double time;
    private final CustomerState patience;


    /**
     * Class constructor
     * Represents the
     * @param recipe
     * @param time waiting time before leaving
     * @param patience patience of the client
     * @see CustomerState
     *
     * @author Yohann
     * @since 1.0
     * @author Jef
     * @since 2.0
     * @version 2.0
     */
    public Order(Recipe recipe, double time, CustomerState patience){
        this.recipe=recipe;
        this.time=time;
        this.patience=patience;
    }

    /**
     * Sets the time to a specified value
     *
     * @param time the waiting time to set
     * @author Yohann
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Get the time parameter
     * @return the waiting time
     * @author Yohann
     */
    public double getTime() {
        return time;
    }


    /**
     * Get the ordered recipe
     * @return the recipe
     * @author Yohann
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Generates a price depending on the waiting time, the patience and the recipe's length
     * @return a double
     * @author Jef
     */
    public double getPrice() {
        switch (this.patience) {
            case NORMAL -> {
                return (recipe.getListIngredient().size()*5 + time/2.5);
            }
            case IMPATIENT -> {
                return (recipe.getListIngredient().size()*5 + time/3);
            }
            default -> {
                return (recipe.getListIngredient().size()*5 + time/2);
            }
        }

    }
}
