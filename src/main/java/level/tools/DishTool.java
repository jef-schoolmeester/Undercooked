package level.tools;

import level.recipe.Dish;

public class DishTool extends Tile implements InterfaceTool{

    protected Dish dish;

    public DishTool(int posX, int posY) {
        super(posX, posY);
        this.dish = null;
    }

    public boolean isUsable(int posX, int posY) {
        int xAxisDifference = Math.abs(posX - this.getPosX());
        int yAxisDifference = Math.abs(posY - this.getPosY());
        return xAxisDifference == 0 && yAxisDifference <= 1 || yAxisDifference == 0 && xAxisDifference <= 1;
    }

    public boolean isEmpty() {
        return this.dish == null;
    }

    public boolean addDish(Dish dish) {
        if (this.dish == null) {
            this.dish = dish;
            return true;
        }
        return false;
    }

    public Dish takeDish() {
        Dish currentDish = this.dish;
        this.dish = null;
        return currentDish;
    }

    public int getDishSize() {
        if (this.dish != null) {
            return this.dish.getListIngredient().size();
        } else {
            return 0;
        }
    }

    public String toString() {
        return "dishTool";
    }

    public String imgPath() {
        return "/IB/floor/void.png";
    }

    public boolean use() {
        return true;
    }
}
