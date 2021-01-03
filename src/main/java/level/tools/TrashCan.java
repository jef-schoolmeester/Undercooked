package level.tools;

import level.recipe.Ingredient;

/**
 * Trashcan class
 * Any ingredients or dishes can be throw in this class
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class TrashCan extends IngredientTool {

    /**
     * Class constructor
     * @param posX X axis position to be set
     * @param posY Y axis position to be set
     * @since 1.0
     */
    public TrashCan(int posX, int posY) {
        super(posX, posY);
    }

    /**
     *
     * @return false because a trashcan cannot be used
     * @since 1.0
     */
    @Override
    public boolean use() {
        return false;
    }

    /**
     *
     * @param ingredient the ingredient to be thrown in the trashcan
     * @return always true, there is no space limit to the trashcan
     * @since 1.0
     */
    public boolean addIngredient(Ingredient ingredient) {
        return true;
    }


    /**
     *
     * @return the class name in a string
     * @since 1.0
     */
    public String toString() {
        return "trashCan";
    }

    /**
     *
     * @return the path to the trashCan png
     * @since 1.0
     */
    public String getImagePath() {
        return "/IB/tools/trashCan.png";
    }
}