package level.tools;

import level.recipe.Dish;

import java.util.ArrayList;

public class Delivery extends DishTool{

    private ArrayList<Dish> preparedDishes;

    public Delivery(int posX, int posY) {
        super(posX, posY);
        this.preparedDishes = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean addDish(Dish dish) {
        this.preparedDishes.add(dish);
        return true;
    }

    @Override
    public Dish takeDish() {
        return null;
    }

    public String toString() {
        return "delivery";
    }

    public String getImagePath() {
        return "/IB/tools/delivery.png";
    }

    public ArrayList<Dish> getPreparedDishes() {
        return preparedDishes;
    }
}
