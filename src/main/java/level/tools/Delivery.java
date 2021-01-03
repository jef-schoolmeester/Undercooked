package level.tools;

import level.recipe.Dish;
import level.recipe.Ingredient;

import java.util.ArrayList;

/**
 * Delivery is the class where the pizzaiolo delivers the prepared dishes for the orders
 * This class extends Dishtool
 * @see DishTool
 * @see Dish
 * @see level.customer.Order
 * @see level.pizzaiolo.Pizzaiolo
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class Delivery extends DishTool{


    private ArrayList<Dish> preparedDishes;

    /**
     * Class constructor
     * @param posX the x axis position
     * @param posY the y axis position
     * @since 2.0
     */
    public Delivery(int posX, int posY) {
        super(posX, posY);
        this.preparedDishes = new ArrayList<>();
    }

    /**
     *  A delivery tool has room for an indefinite number of dishes
     * @return returns true
     * @since 1.0
     */
    @Override
    public boolean isEmpty() {
        return true;
    }

    /**
     *
     * @param dish the dish to be added in the tool
     * @return if the operation was successful or not
     * @since 1.0
     */
    @Override
    public boolean addDish(Dish dish) {
        this.preparedDishes.add(dish);
        return true;
    }

    /**
     * A delivered dish cannot be taken from this tool
     * @return null
     * @since 1.0
     */
    @Override
    public Dish takeDish() {
        return null;
    }

    /**
     *
     * @return the class name as string
     * @since 2.0
     */
    public String toString() {
        return "delivery";
    }

    /**
     *
     * @return the image path to the delivery tool
     * @since 2.0
     */
    public String getImagePath() {
        return "/IB/tools/delivery.png";
    }

    /**
     *
     * @return the list of dishes delivered by the pizzaiolo
     */
    public ArrayList<Dish> getPreparedDishes() {
        return preparedDishes;
    }
}
