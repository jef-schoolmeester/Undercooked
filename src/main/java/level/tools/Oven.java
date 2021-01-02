package level.tools;

import level.recipe.Dish;
import level.recipe.StateDish;
import level.recipe.StateIngredient;
import level.threads.OvenThread;

public class Oven extends DishTool {

    private OvenThread ovenThread;

    public Oven(int posX, int posY) {
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
    public void cook() {
        if (this.dish.getStateDish() == StateDish.RAW) {
            this.dish.setStateDish(StateDish.COOKED);
        } else {
            this.dish.setStateDish(StateDish.TRASH);
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
    public String getImagePath() {
        return "/IB/tools/oven.png";
    }

    public void stopThread() {
        this.ovenThread.stopRunning();
    }
}
