package level.tools;

/**
 * Knife class
 * Used to transform most of the ingredients
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class Knife extends IngredientTool {

    /**
     * Class constructor
     * @param posX X axis position to be set
     * @param posY Y axis position to be set
     * @since 1.0
     */
    public Knife(int posX, int posY) {
        super(posX, posY);
    }

    /**
     *
     * @return the class name as string
     * @since 1.0
     */
    public String toString() {
        return "knife";
    }

    /**
     *
     * @return an image path to the knife
     * @since 1.0
     */
    public String getImagePath() {
        return "/IB/tools/knife.png";
    }
}