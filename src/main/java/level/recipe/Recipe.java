package level.recipe;

import java.util.ArrayList;

/*
 * Class Recipe
 * Has an ArrayList<Ingredient> listIngredient and a StateRecipe state as arguments
 *
 * @author Pierre Abeille
 */

public class Recipe {

	protected ArrayList<Ingredient> listIngredient;
	protected StateRecipe state;


	protected Recipe() {
		this.listIngredient = new ArrayList<>();
		this.state = StateRecipe.RAW;
	}

	public Recipe(ArrayList<Ingredient> listIngredient) {
		this.listIngredient = listIngredient;
		this.state = StateRecipe.RAW;
	}


// Je ne sais pas quelle méthode est la plus simple, ou bien celle qu'on devrait utiliser le plus, aussecour
// Bien que celle qui n'est pas en commentaire me semble plus simple et le booleen peut aider a la gestion des erreurs

	/*public void removeIngredient(Ingredient ig) {


		int ingredientAt = 0;
		for(Ingredient i : this.listIngredient) {
			if(i==ig) {
				ingredientAt = this.listIngredient.indexOf(i);
			}
		}
		this.listIngredient.remove(ingredientAt);

		this.listIngredient.remove(ig);
	}*/

	public StateRecipe getState() {
		return this.state;
	}

	public void setState(StateRecipe state) {
		this.state = state;
	}

}
