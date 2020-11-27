package level.pizzaiolo;

import level.recipe.Dish;
import level.recipe.Ingredient;

public class Hand {
      private Ingredient ingredient;
      private Dish dish;

      public Hand() {
          this.ingredient = null;
          this.dish = null;
      }

      public boolean isHandFull() {
          return this.dish != null || this.ingredient != null;
      }

      public boolean isIngredient() {
          return this.ingredient != null && this.dish == null;
      }

    public boolean isDish() {
        return this.dish != null && this.ingredient == null;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Dish getDish() {
        return dish;
    }

    protected void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    protected void setDish(Dish dish) {
        this.dish = dish;
    }
}
