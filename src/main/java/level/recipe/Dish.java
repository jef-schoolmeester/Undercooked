package level.recipe;

import java.util.ArrayList;
import java.util.Iterator;

public class Dish extends Recipe{

    public Dish() {
        super();
    }

    public Dish(ArrayList<Ingredient> listIngredient) {
        super(listIngredient);
    }

    public void addIngredient(Ingredient ingredient) {
        this.listIngredient.add(ingredient);
        this.checkCurrentState();
    }

    /*public void addIngredient(Ingredient ingredient, int index) { -- I don't know if this method is necessary
        this.listIngredient.add(index, ingredient);
    }*/

    public void checkCurrentState() {

        boolean isTrash = false;
        Iterator<Ingredient> iterator = this.listIngredient.iterator();
        while (iterator.hasNext() && !isTrash) {
            if (iterator.next().getState() == StateIngredient.TRASH) {
                isTrash = true;
            }
        }
        if (isTrash) {
            this.setState(StateRecipe.TRASH);
        }
    }
}
