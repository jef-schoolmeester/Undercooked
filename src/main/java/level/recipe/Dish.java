package level.recipe;

import java.util.ArrayList;
import java.util.Iterator;

public class Dish {

    private ArrayList<Ingredient> listIngredient;
    private StateDish stateDish;

    public Dish() {
        this.listIngredient = new ArrayList<>();
    }

    public Dish(Ingredient ingredient) {
        this.listIngredient = new ArrayList<>();
        this.listIngredient.add(ingredient);
        this.checkCurrentState();
    }

    public void addIngredient(Ingredient ingredient) {
        this.listIngredient.add(ingredient);
        this.checkCurrentState();
    }

    public StateDish getStateDish() {
        return this.stateDish;
    }

    public void setStateDish(StateDish stateDish) {
        this.stateDish = stateDish;
    }

    public ArrayList<Ingredient> getListIngredient() {
        return this.listIngredient;
    }

    /*public void addIngredient(Ingredient ingredient, int index) { -- I don't know if this method is necessary
        this.listIngredient.add(index, ingredient);
    }*/

    public void checkCurrentState() {
        if (this.stateDish != StateDish.TRASH) {
            boolean isTrash = false;
            Iterator<Ingredient> iterator = this.listIngredient.iterator();
            while (iterator.hasNext() && !isTrash) {
                if (iterator.next().getState() == StateIngredient.TRASH) {
                    isTrash = true;
                }
            }
            if (isTrash) {
                this.setStateDish(StateDish.TRASH);
            }
        }
    }



    // Je ne sais pas quelle méthode est la plus simple, ou bien celle qu'on devrait utiliser le plus, aussecour
    // Bien que celle qui n'est pas en commentaire me semble plus simple et le booleen peut aider a la gestion des erreurs

	/*public void removeIngredient(Ingredient ig) {


		int ingredientAt = 0;
				ingredientAt = this.listIngredient.indexOf(i);
		for(Ingredient i : this.listIngredient) {
			if(i==ig) {
			}
		}
		this.listIngredient.remove(ingredientAt);

		this.listIngredient.remove(ig);
	}*/
}
