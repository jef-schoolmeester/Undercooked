package src.level.recipe;

/*
 * Class Ingredients
 * Has a String name and a State state as arguments
 * 
 * @author Pierre Abeille
 */

public class Ingredient {

	private String name;
	private StateIngredient state;
	private Tool requiredTool;
	
	public Ingredient(String name, StateIngredient state, Tool rTool) {
		this.name = name;
		this.state = state;
		this.requiredTool = rTool;
	}

	public String getName() {
		return name;
	}

	public StateIngredient getState() {
		return state;
	}

	public void setState(StateIngredient state) {
		this.state = state;
	}
}
