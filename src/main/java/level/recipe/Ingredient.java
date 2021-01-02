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

	public Ingredient(String name, String requiredTool) {
		this.name = name;
		this.state = StateIngredient.FRESH;
		this.requiredTool = requiredTool;
	}

	public Ingredient(String name, StateIngredient state, String requiredTool) {
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
		return new Ingredient(this.getName(), this.getRequiredTool());
	}

	public String getImagePath() {
		switch (this.state) {
			case FRESH -> {
				return "/IB/ingredients/" + this.name + ".png";
			}
			case PREPARED -> {
				return "/IB/ingredients/" + this.name + "Prepared.png";
			}
			default -> {
				return "/IB/ingredients/trash.png";
			}
		}
	}

	public String toString() {
		return name+ " " + state.toString() + " " + requiredTool;
	}
}
