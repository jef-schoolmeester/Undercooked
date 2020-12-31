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
        return this.preparedDishes.isEmpty();
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

    public String imgPath() {
        return "/IB/tools/delivery.png";
    }
}
