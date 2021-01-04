package level.tools;

/**
 * Grater class
 * Used to transform ingredients like cheese
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class Grater extends IngredientTool {
    /**
     * Class constructor
     * @param posX X axis position to be set
     * @param posY Y axis position to be set
     * @since 1.0
     */
    public Grater(int posX, int posY) {
        super(posX, posY);
    }

    /**
     *
     * @return the class name
     * @since 1.0
     */
    public String toString() {
        return "grater";
    }

    /**
     *
     * @return the image path to the grater
     * @since 1.0
     */
    public String getImagePath() {
        return "/IB/tools/grater.png";
    }
}