package level.tools;

import level.recipe.Dish;
import level.recipe.Ingredient;

public class Workplan extends DishTool {

    public Workplan(int posX, int posY) {
        super(posX, posY);
    }

    public boolean addIngredient(Ingredient ingredient) {
        if (this.isEmpty()) {
            this.dish = new Dish(ingredient);
        } else {
            this.dish.addIngredient(ingredient);
        }
        return true;
    }

    public String toString() {
        return "workplan";
    }

    public String getImagePath() {
        return "/IB/tools/workplan.png";
    }
}