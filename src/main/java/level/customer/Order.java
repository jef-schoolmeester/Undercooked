package level.customer;

import level.recipe.Recipe;
/*
 * Order class
 *
 * Defined by a recipe, a realisation time and a price
 * Has 1 constructor and a leave() method
 *
 * @author Yohann
 */
public class Order {

    private Recipe recipe;
    private double time;
    private CustomerState patience;

    public Order(Recipe recipe, double time, CustomerState patience){
        this.recipe=recipe;
        this.time=time;
        this.patience=patience;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public double getPrice() {
        switch (this.patience) {
            case NORMAL -> {
                return (recipe.getListIngredient().size()*5 + time/2.5);
            }
            case IMPATIENT -> {
                return (recipe.getListIngredient().size()*5 + time/3);
            }
            default -> {
                return (recipe.getListIngredient().size()*5 + time/2);
            }
        }

    }
}
