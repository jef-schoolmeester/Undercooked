package level.customer;

import level.recipe.Recipe;
/*
 * Order class
 *
 * Defined by a recipe, a realisation time and a price
 * Has 1 constructor and a getTime() method
 *
 * @author Yohann
 */
public class Order {

    private Recipe recipe;
    private int time;
    private double price;

    public Order(Recipe recipe, int time, double price){
        this.recipe=recipe;
        this.time=time;
        this.price=price;
    }

    public int getTime(){ return time;}

}
