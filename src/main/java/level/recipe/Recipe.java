package level.recipe;

import java.util.ArrayList;

/*
 * Class Recipe
 * Has an ArrayList<Ingredient> listIngredient and a StateRecipe state as arguments
 *
 * @author Pierre Abeille
 */

public class Recipe {

	private ArrayList<Ingredient> listIngredient;

	public Recipe(ArrayList<Ingredient> listIngredient) {
		this.listIngredient = listIngredient;
	}

	public boolean isDishMatching(Dish dish) {
		return dish.getStateDish() == StateDish.COOKED && this.listIngredient.equals(dish.getListIngredient());
	}

	public ArrayList<Ingredient> getListIngredient() {
		return listIngredient;
	}
}
