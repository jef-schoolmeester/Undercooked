package level.tools;

import level.recipe.StateDish;
import level.recipe.StateIngredient;

public class Oven extends DishTool {

    public Oven(int posX, int posY) {
        super(posX, posY);
    }

    public boolean use() {
        return true;
        //A FAIRE
    }
    
    public String toString() {
        return "oven";
    }

    public String imgPath() {
        return "/IB/tools/oven.png";
    }
}
