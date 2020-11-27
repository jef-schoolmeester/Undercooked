package level.tools;

import level.recipe.Ingredient;

public class IngredientContainer extends Tool{

    public IngredientContainer(int posX, int posY, Ingredient ingredient) {
        super(posX, posY);
        this.ingredient = ingredient;
    }

    @Override
    public boolean use() {
        return false;
    }

    @Override
    public Ingredient takeIngredient() {
        return this.ingredient;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return ingredient.getClass() == ingredient.getClass();
    }


}