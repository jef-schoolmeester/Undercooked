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
    private int time;
    private double price;
    private CustomerState patience;

    public Order(Recipe recipe, int time, double price, CustomerState patience){
        this.recipe=recipe;
        this.time=time;
        this.price=price;
        this.patience=patience;
    }

    public void leave(){
        if (time==0){
            //Partir
        }
    }

}
