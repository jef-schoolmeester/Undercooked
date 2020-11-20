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
	private StateRecipe state;


	public Recipe() {
		this.listIngredient = new ArrayList<Ingredient>();
		this.state = StateRecipe.RAW;
	}

	public Recipe(ArrayList<Ingredient> listIngredient) {
		this.listIngredient = listIngredient;
		this.state = StateRecipe.RAW;
	}

	public void addIngredient(Ingredient ig) {
		this.listIngredient.add(ig);
	}

	public void addIngredient(Ingredient ig, int i) {
		this.listIngredient.add(i, ig);
	}

	public void removeIngredient(Ingredient ig) {

// Je ne sais pas quelle méthode est la plus simple, ou bien celle qu'on devrait utiliser le plus, aussecour
// Bien que celle qui n'est pas en commentaire me semble plus simple et le booleen peut aider a la gestion des erreurs

//		int ingredientAt = 0;
//		for(Ingredient i : this.listIngredient) {
//			if(i==ig) {
//				ingredientAt = this.listIngredient.indexOf(i);
//			}
//		}
//		this.listIngredient.remove(ingredientAt);

		this.listIngredient.remove(ig);
	}

	public void currentState() {
//Methode a utiliser seulement lorsque tout les ingredients sont dans la liste lors de la preparation, pour l'instant

		boolean trash = false;

		for(Ingredient i : this.listIngredient) {
			if(i.getState() == StateIngredient.TRASH) {
				trash = true;
			}
		}

		if(trash) {
			this.setState(StateRecipe.TRASH);
		}
	}

	public StateRecipe getState() {
		return this.state;
	}

	private void setState(StateRecipe state) {
		this.state = state;
	}

}
