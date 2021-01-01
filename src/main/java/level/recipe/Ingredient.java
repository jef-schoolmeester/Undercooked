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
	private String requiredTool;
	private String imagePath;

	public Ingredient(String name, String requiredTool, String imagePath) {
		this.name = name;
		this.state = StateIngredient.FRESH;
		this.requiredTool = requiredTool;
		this.imagePath = imagePath;
	}

	public Ingredient(String name, StateIngredient state, String requiredTool, String imagePath) {
		this.name = name;
		this.state = state;
		this.requiredTool = requiredTool;
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public StateIngredient getState() {
		return state;
	}


	public String getRequiredTool() {
		return this.requiredTool;
	}


	public void setState(StateIngredient state) {
		this.state = state;
	}


	@Override
	public boolean equals(Object object) {
		if (object.getClass() == Ingredient.class) {
			return this.name.equals(((Ingredient) object).getName()) && this.state == ((Ingredient) object).getState();
		} else {
			return false;
		}
	}

	public Ingredient getRawIngredient() {
		return new Ingredient(this.getName(), this.getRequiredTool(), this.imagePath);
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public String toString() {
		return name+ " " + state.toString() + " " + requiredTool;
	}
}
