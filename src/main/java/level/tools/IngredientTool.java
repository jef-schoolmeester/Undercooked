package level.tools;

import level.recipe.Ingredient;
import level.recipe.StateIngredient;

public class IngredientTool extends Tile implements InterfaceTool{

    protected Ingredient ingredient;

    public IngredientTool(int posX, int posY) {
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
        this.ingredient = null;
        return currentIngredient;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public boolean isEmpty() {
        return this.ingredient == null;
    }

    public boolean use() {
        if (this.isEmpty()) {
            return false;
        } else {
            if(this.getIngredient().getRequiredTool() != this.getClass().toString()) {
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

    public String toString() {
        return "ingredienttool";
    }
}