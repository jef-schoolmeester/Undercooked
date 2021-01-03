package level.tools;

import level.recipe.Ingredient;

/**
 * Ingredient container class
 * Used to store any ingredient
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class IngredientContainer extends IngredientTool {

    /**
     * Class constructor
     * @param posX X axis position to be set
     * @param posY Y axis position to be set
     * @param ingredient ingredient to store
     * @since 1.0
     */
    public IngredientContainer(int posX, int posY, Ingredient ingredient) {
        super(posX, posY);
        this.ingredient = ingredient;
    }

    /**
     *
     * @return false, an ingredient container cannot be used
     * @since 1.0
     */
    @Override
    public boolean use() {
        return false;
    }

    /**
     *
     * @return the stored ingredient
     * @since 1.0
     */
    @Override
    public Ingredient takeIngredient() {
        return new Ingredient(this.ingredient.getName(), this.ingredient.getState(), this.ingredient.getRequiredTool());
    }

    /**
     *
     * @param ingredient ingredient to be stored
     * @return true if the ingredient to be stored is the same type as the stored ingredient
     * @since 1.0
     */
    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return ingredient.getClass() == ingredient.getClass();
    }

    /**
     *
     * @return returns the class name as string
     * @since 2.0
     */
    public String toString() {
        return "ingredientContainer";
    }

    /**
     *
     * @return the image path to the stored ingredient
     * @since 2.0
     */
    public String getImagePath() {
        return this.ingredient.getImagePath();
    }
}