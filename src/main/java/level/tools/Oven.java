package level.tools;

import level.recipe.Dish;
import level.recipe.StateDish;
import level.recipe.StateIngredient;
import level.threads.OvenThread;

/**
 * Oven is the class that cooks(ord burns) Dish objects
 * This class is managed by a OvenThread
 * This class extends Dishtool
 * @see OvenThread
 * @see DishTool
 * @see Dish
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class Oven extends DishTool {

    private OvenThread ovenThread;

    /**
     * Class constructor
     * @param posX the x axis position
     * @param posY the y axis position
     */
    public Oven(int posX, int posY) {
        super(posX, posY);
        this.ovenThread = new OvenThread(this);
        this.ovenThread.start();
    }

    /**
     * Take the dish from the oven if there is a dish
     * @return the taken dish
     */
    @Override
    public Dish takeDish() {
        Dish currentDish = this.dish;
        this.dish = null;
        this.ovenThread.toggle();
        return currentDish;
    }

    /**
     * cooks the dish
     * If the dish is already cooked, the dish becomes trash
     */
    public void cook() {
        if (this.dish.getStateDish() == StateDish.RAW) {
            this.dish.setStateDish(StateDish.COOKED);
        } else {
            this.dish.setStateDish(StateDish.TRASH);
        }
    }

    /**
     * toggle the Oventhread that manages the oven
     * @return true
     */
    @Override
    public boolean use() {
        ovenThread.toggle();
        return true;
    }

    /**
     *
     * @return the class as string
     */
    @Override
    public String toString() {
        return "oven";
    }

    /**
     *
     * @return the image path to the oven
     */
    @Override
    public String getImagePath() {
        return "/IB/tools/oven.png";
    }

    /**
     * stops the OvenThread
     */
    public void stopThread() {
        this.ovenThread.stopRunning();
    }
}
