package level.recipe;

import java.util.ArrayList;

/**
 * Class Recipe is the object composing an client's order
 * Has an ArrayList<Ingredient> listIngredient and a StateRecipe state as arguments
 *
 * @author Pierre
 * @since 1.0
 * @author Jef
 * @since 2.0
 * @version 2.0
 */

public class Recipe {

	private ArrayList<Ingredient> listIngredient;

	/**
	 * Class constructor
	 * @param listIngredient the list of ingredients composing the recipe
	 * @since 1.0
	 */
	public Recipe(ArrayList<Ingredient> listIngredient) {
		this.listIngredient = listIngredient;
	}

	/**
	 *
	 * @param dish the dish to compare
	 * @return 	<code>true</code> if the dish is cooked and if the dish's ingredients list equals the recipe's one
	 * 			<code>false</code> otherwise
	 * @since 2.0
	 */
	public boolean isDishMatching(Dish dish) {
		return dish.getStateDish() == StateDish.COOKED && this.listIngredient.equals(dish.getListIngredient());
	}

	/**
	 *
	 * @return the recipe's list of ingredients
	 * @since 1.0
	 */
	public ArrayList<Ingredient> getListIngredient() {
		return listIngredient;
	}

	/**
	 * Generates a string representing the recipe's state
	 * @return the generated String
	 * @since 2.0
	 */
	public String toString() {
		String value = "";
		for (Ingredient i: listIngredient) {
			value += i.toString() + " ";
		}
		return value;
	}
}
