package level.tools;

import level.recipe.Dish;
import level.recipe.StateDish;
import level.recipe.StateIngredient;
import level.threads.OvenThread;

public class Oven extends DishTool {

    private OvenThread ovenThread;

    public Oven(int posX, int posY) throws InterruptedException {
        super(posX, posY);
        this.ovenThread = new OvenThread(this);
        this.ovenThread.start();
    }

    @Override
    public Dish takeDish() {
        Dish currentDish = this.dish;
        this.dish = null;
        this.ovenThread.toggle();
        return currentDish;
    }

    //Function name
    public void burn() {
        switch (this.dish.getStateDish()) {
            case RAW -> this.dish.setStateDish(StateDish.COOKED);
            default -> this.dish.setStateDish(StateDish.TRASH);
        }
    }

    @Override
    public boolean use() {
        ovenThread.toggle();
        return true;
    }

    @Override
    public String toString() {
        return "oven";
    }

    @Override
    public String imgPath() {
        return "/IB/tools/oven.png";
    }
}
