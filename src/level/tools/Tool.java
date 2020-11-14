package level.tools;

import level.reciepe.Ingredient;

public abstract class Tool extends Tile {

    private Ingredient ingredient;

    public Tool(int posX, int posY) {
        super(posX, posY);
        this.ingredient = null;
    }

    public boolean isUsable(int posX, int posY) {
        int xAxisDifference = Math.abs(posX - this.getPosX());
        int yAxisDifference = Math.abs(posY - this.getPosY());
        return xAxisDifference == 0 && yAxisDifference <= 1 || yAxisDifference == 0 && xAxisDifference <= 1;
    }

    public boolean addIngredient(Ingredient ingredient) {
        if (this.ingredient == null) {
            this.ingredient = ingredient;
            return true;
        }
        return false;
    }

    public Ingredient takeIngredient() {
        Ingredient currentIngredient = this.ingredient;
        if (currentIngredient == null) {
            return null;
        }
        this.ingredient = null;
        return currentIngredient;
    }

    public abstract boolean use();

}
