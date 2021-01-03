package level.tools;

import level.recipe.Dish;
import level.recipe.Ingredient;

/**
 *  IngredientTool class is the base class for all tools that mainly work with dishes
 *  This class extends Tile, and implements InterfaceTool
 *
 * @see InterfaceTool
 * @see Dish
 * @see Tile
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class DishTool extends Tile implements InterfaceTool{

    protected Dish dish;

    /**
     * Class constructor
     * @param posX xAxis position on the level table
     * @param posY yAxis position on the level table
     * @since 1.0
     */
    public DishTool(int posX, int posY) {
        super(posX, posY);
        this.dish = null;
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
     *
     * @return true if the tool is empty, false otherwise
     * @since 1.0
     */
    public boolean isEmpty() {
        return this.dish == null;
    }


    /**
     * If the dish tool is empty, add dish
     * @param dish the dish to be added in the tool
     * @return true if the operation was successful, false otherwise
     * @since 1.0
     */
    public boolean addDish(Dish dish) {
        if (this.dish == null) {
            this.dish = dish;
            return true;
        }
        return false;
    }

    /**
     *
     * @return the removed dish
     * @since 1.0
     */
    public Dish takeDish() {
        Dish currentDish = this.dish;
        this.dish = null;
        return currentDish;
    }

    /**
     *
     * @return current dish's arrayList of ingredient size
     * @since 2.0
     */
    public int getDishSize() {
        if (this.dish != null) {
            return this.dish.getListIngredient().size();
        } else {
            return 0;
        }
    }

    /**
     *
     * @return the class name
     * @since 2.0
     */
    public String toString() {
        return "dishTool";
    }

    /**
     *
     * @return the image path
     * @since 2.0
     */
    public String getImagePath() {
        return "/IB/floor/void.png";
    }

    /**
     *  if there is an dish to use, use the tool
     * @return if the operation was successful
     * @since 1.0
     */
    public boolean use() {
        return true;
    }
}
