package level.tools;

import level.recipe.Ingredient;

public class IngredientContainer extends IngredientTool {

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
        return new Ingredient(this.ingredient.getName(), this.ingredient.getState(), this.ingredient.getRequiredTool());
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return ingredient.getClass() == ingredient.getClass();
    }

    public String toString() {
        return "ingredientContainer";
    }

    public String getImagePath() {
        return this.ingredient.getImagePath();
    }
}