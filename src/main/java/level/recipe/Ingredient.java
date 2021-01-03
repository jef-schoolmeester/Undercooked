package level.recipe;

/**
  Class Ingredient
  Has a String name, a StateIngredient state as arguments and a String requiredTool
  A ingredient will have an image depending on it's name and state
  @see level.tools.IngredientTool
 * @see level.recipe.StateIngredient
 *
 * @author Pierre
 * @since 1.0
 * @author Jef
 * @since 2.0
 * @version 2.0
 */

import level.tools.IngredientTool;

public class Ingredient {

	private String name;
	private StateIngredient state;
	private String requiredTool;

	/**
	 * Class constructor
	 * Creates a FRESH ingredient
	 * @param name the ingredient's name
	 * @param requiredTool the required tool to prepare the ingredient or 'none'
	 * @since 2.0
	 */
	public Ingredient(String name, String requiredTool) {
		this.name = name;
		this.state = StateIngredient.FRESH;
		this.requiredTool = requiredTool;
	}

	/**
	 * Class constructor
	 * @param name the ingredient's name
	 * @param state the ingredient's state
	 * @param requiredTool the required tool to prepare the ingredient or 'none'
	 * @since 2.0
	 */
	public Ingredient(String name, StateIngredient state, String requiredTool) {
		this.name = name;
		this.state = state;
		this.requiredTool = requiredTool;
	}

	/**
	 *
	 * @return the ingredient's name as String
	 * @since 1.0
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @return the ingredient's current state as StateIngredient
	 * @since 1.0
	 */
	public StateIngredient getState() {
		return state;
	}

	/**
	 *
	 * @return the ingredient's required tool as String
	 * @since 2.0
	 */
	public String getRequiredTool() {
		return this.requiredTool;
	}

	/**
	 * Set the ingredient's state
	 * @param state the state to set
	 * @since 1.0
	 */
	public void setState(StateIngredient state) {
		this.state = state;
	}

	/**
	 *
	 * @param object the object to compare to
	 * @return 	<code>true</code> if the the object is an ingredient with the same properties
	 * 			<code>false</code> otherwise
	 * @since 2.0
	 */
	@Override
	public boolean equals(Object object) {
		if (object.getClass() == Ingredient.class) {
			return this.name.equals(((Ingredient) object).getName()) && this.state == ((Ingredient) object).getState();
		} else {
			return false;
		}
	}

	/**
	 *
	 * @return the raw version of the current ingredient
	 * @since 2.0
	 */
	public Ingredient getRawIngredient() {
		return new Ingredient(this.getName(), this.getRequiredTool());
	}

	/**
	 * generates an imagePath for the ingredient depending on it's name and state
	 * @return the generated string
	 * @since 2.0
	 */
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

	/**
	 * Generates a string representing the ingredient's current state
	 * @return the generated String
	 * @since 2.0
	 */
	public String toString() {
		return name+ " " + state.toString() + " " + requiredTool;
	}
}
