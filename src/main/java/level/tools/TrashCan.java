package level.tools;

import level.recipe.Ingredient;

public class TrashCan extends IngredientTool {
    public TrashCan(int posX, int posY) {
        super(posX, posY);
    }


    @Override
    public boolean use() {
        return false;
    }

    public boolean addIngredient(Ingredient ingredient) {
        return true;
    }

    public Ingredient takeIngredient() {
        return null;
    }

    public String toString() {
        return "trashCan";
    }

    public String imgPath() {
        return "/IB/tools/trashCan.png";
    }
}