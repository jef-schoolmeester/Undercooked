package level.recipe;

/*
 * Class Ingredients
 * Has a String name and a StateIngredient state as arguments
 * 
 * @author Pierre Abeille
 */

import level.tools.Tool;

public class Ingredient {

	private String name;
	private StateIngredient state;
	private Tool requiredTool;

	public Ingredient(String name, Tool requiredTool) {
		this.name = name;
		this.state = StateIngredient.FRESH;
		this.requiredTool = requiredTool;
	}

	public Ingredient(String name, StateIngredient state, Tool requiredTool) {
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


	public Tool getRequiredTool() {
		return this.requiredTool;
	}


	public void setState(StateIngredient state) {
		this.state = state;
	}


	public boolean equals(Ingredient ingredient) {
		return this.name.equals(ingredient.getName()) && this.state == ingredient.getState();
	}
}
