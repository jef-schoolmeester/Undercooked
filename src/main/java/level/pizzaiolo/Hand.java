package level.pizzaiolo;

import level.recipe.Dish;
import level.recipe.Ingredient;

/**
 * Hand is the class that define the pizzaiolo's inventory
 * A Hand can have a Ingredient or a Dish but not at the same time
 * @see Pizzaiolo
 * @see Dish
 * @see Ingredient
 *
 * @author Pierre
 * @since 1.0
 * @author Jef
 * @since 2.0
 * @version 2.0
 */
public class Hand {
      private Ingredient ingredient;
      private Dish dish;


    /**
     * Class constructor
     * Generates a empty hand
     * @since 1.0
     */
    public Hand() {
          this.ingredient = null;
          this.dish = null;
      }

    /**
     *
     * @return  <code>true</code> if one of the two parameters is not null;
     *          <code>false</code> otherwise.
     * @since 1.0
     */
    public boolean isHandFull() {
          return this.dish != null || this.ingredient != null;
      }

    /**
     *
     * @return  <code>true</code> if the Hand carries an Ingredient;
     *          <code>false</code> otherwise.
     * @since 1.0
     */
      public boolean isIngredient() {
          return this.ingredient != null && this.dish == null;
      }

    /**
     *
     * @return  <code>true</code> if the Hand carries a Dish;
     *          <code>false</code> otherwise.
     * @since 1.0
     */
      public boolean isDish() {
        return this.dish != null && this.ingredient == null;
    }

    /**
     *
     * @return current ingredient
     * @since 1.0
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     *
     * @return current dish
     * @since 1.0
     */
    public Dish getDish() {
        return this.dish;
    }

    /**
     *
     * @param ingredient the ingredient to set
     * @since 1.0
     */
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    /**
     *
     * @param dish the dish to set
     * @since 1.0
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * Generates a string to show the object's state
     * @return a string
     * @author Jef
     * @since 2.0
     */
    public String toString() {
          if (this.ingredient != null) {
              return this.ingredient.toString();
          } else if (this.dish != null) {
              return this.dish.toString();
          } else {
              return "The hand is empty";
          }
    }

}
