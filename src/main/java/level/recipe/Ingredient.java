package level.recipe;

/*
 * Class Ingredients
 * Has a String name and a StateIngredient state as arguments
 * 
 * @author Pierre Abeille
 */

import level.tools.IngredientTool;

public class Ingredient {

	private String name;
	private StateIngredient state;
	private IngredientTool requiredTool;

	public Ingredient(String name, IngredientTool requiredTool) {
		this.name = name;
		this.state = StateIngredient.FRESH;
		this.requiredTool = requiredTool;
	}

	public Ingredient(String name, StateIngredient state, IngredientTool requiredTool) {
		this.name = name;
		this.state = state;
		this.requiredTool = requiredTool;
	}

	public String getName() {
		return name;
	}

	public StateIngredient getState() {
		return state;
	}


	public IngredientTool getRequiredTool() {
		return this.requiredTool;
	}


	public void setState(StateIngredient state) {
		this.state = state;
	}


	public boolean equals(Ingredient ingredient) {
		return this.name.equals(ingredient.getName()) && this.state == ingredient.getState();
	}
}
