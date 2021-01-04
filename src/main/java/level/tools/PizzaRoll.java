package level.tools;

/**
 * PizzaRoll class
 * Used to transform dough
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class PizzaRoll extends IngredientTool {

    /**
     * Class constructor
     * @param posX X axis position to be set
     * @param posY Y axis position to be set
     * @since 1.0
     */
    public PizzaRoll(int posX, int posY) {
        super(posX, posY);
    }

    /**
     *
     * @return the class name
     */
    public String toString() {
        return "pizzaRoll";
    }

    /**
     *
     * @return a image path to thr pizzaRoll
     */
    public String getImagePath() {
        return "/IB/tools/pizzaRoll.png";
    }
}
