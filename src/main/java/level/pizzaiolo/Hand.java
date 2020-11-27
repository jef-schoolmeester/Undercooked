package level.pizzaiolo;

import level.recipe.Dish;
import level.recipe.Ingredient;

public class Hand {
      private Ingredient ingredient;
      private Dish dish;
      private Boolean isHandFull;

      public Hand() {
          this.ingredient = null;
          this.dish = null;
      }
}
