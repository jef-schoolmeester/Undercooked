package level.tools;

import level.recipe.Ingredient;
import level.recipe.StateIngredient;

/**
 *  IngredientTool class is the base class for all tools that only work with ingredients
 *  This class extends Tile, and implements InterfaceTool
 *
 * @see InterfaceTool
 * @see Ingredient
 * @see Tile
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class IngredientTool extends Tile implements InterfaceTool{

    protected Ingredient ingredient;

    /**
     * Class constructor
     * @param posX xAxis position on the level table
     * @param posY yAxis position on the level table
     * @since 1.0
     */
    public IngredientTool(int posX, int posY) {
        super(posX, posY);
        this.ingredient = null;
    }

    /**
     *
     * @param posX the X position of the pizzaiolo
     * @param posY the Y position of the pizzaiolo
     * @return true if the pizzaiolo is within 1 tile of the tool
     *         false otherwise
     * @since 1.0
     */
    public boolean isUsable(int posX, int posY) {
        int xAxisDifference = Math.abs(posX - this.getPosX());
        int yAxisDifference = Math.abs(posY - this.getPosY());
        return xAxisDifference == 0 && yAxisDifference <= 1 || yAxisDifference == 0 && xAxisDifference <= 1;
    }

    /**
     * If the ingredient tool is empty, add an ingredient
     * @param ingredient the ingredient to be added in the tool
     * @return true if the operation was successful, false otherwise
     * @since 1.0
     */
    public boolean addIngredient(Ingredient ingredient) {
        if (this.ingredient == null) {
            this.ingredient = ingredient;
            return true;
        }
        return false;
    }

    /**
     *
     * @return the removed ingredient
     * @since 1.0
     */
    public Ingredient takeIngredient() {
        Ingredient currentIngredient = this.ingredient;
        this.ingredient = null;
        return new Ingredient(currentIngredient.getName(), currentIngredient.getState(), currentIngredient.getRequiredTool());
    }

    /**
     *
     * @return the current ingredient
     * @since 2.0
     */
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    /**
     *
     * @return true if the tool is empty, false otherwise
     * @since 1.0
     */
    public boolean isEmpty() {
        return this.ingredient == null;
    }

    /**
     * if there is an ingredient to use, transfrom the ingredient
     * @return true if the operation was successful, false otherwise
     * @since 1.0
     */
    public boolean use() {
        if (this.isEmpty()) {
            return false;
        } else {
            if(this.getIngredient().getRequiredTool().equals(this.toString())) {
                if (this.getIngredient().getState() == StateIngredient.FRESH) {
                    this.getIngredient().setState(StateIngredient.PREPARED);
                } else {
                    this.getIngredient().setState(StateIngredient.TRASH);
                }
            } else {
                this.getIngredient().setState(StateIngredient.TRASH);
            }
            return true;
        }
    }

    /**
     *
     * @return the class's name
     * @since 2.0
     */
    public String toString() {
        return "ingredientTool";
    }

    /**
     *
     * @return the image path to this class's png
     * @since 2.0
     */
    public String getImagePath() {
        return "/IB/floor/void.png";
    }
}