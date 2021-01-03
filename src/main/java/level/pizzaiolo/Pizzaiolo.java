package level.pizzaiolo;
//package level;

import level.tools.DishTool;
import level.tools.IngredientTool;
import level.tools.Workplan;

/**
 * Pizzaiolo is the class that interacts with all the different tools in a level.
 * This class has an inventory represented by the class Hand and a 2 dimensional position.
 * @see Hand
 * @see sample.level.LevelController
 * @see level.Level
 *
 * @author Pierre
 * @since 1.0
 * @author Jef
 * @since 2.0
 * @version 2.0
 */
public class Pizzaiolo {
    private int posX;
    private int posY;
    private final Hand hand;


    /**
     * Class constructor
     * Generate a pizzaiolo with a empty hand at the position 0,0 of the game grid
     * @since 1.0
     */
    public Pizzaiolo() {
        this.posX = 0;
        this.posY = 0;
        this.hand = new Hand();
    }

    /**
     * Class constructor
     * Generate a pizzaiolo with a empty hand at a specified position
     * @param posX the starting X axis position
     * @param posY the starting Y axis position
     * @since 1.0
     */
    public Pizzaiolo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hand = new Hand();
    }

    /**
     * Use a ingredient tool
     * @param ingredientTool the tool used
     * @see IngredientTool
     * @return  <code>true</code> if the operation was successful
     *          <code>false</code> otherwise
     * @since 2.0
     */
    public boolean useIngredientTool(IngredientTool ingredientTool){
        if (ingredientTool.isUsable(this.posX, this.posY)) {
            if (!this.hand.isDish()) {
                if (this.hand.isHandFull() && ingredientTool.isEmpty()) {
                    ingredientTool.addIngredient(this.hand.getIngredient());
                    this.hand.setIngredient(null);
                    ingredientTool.use();
                    return true;
                } else if (!ingredientTool.isEmpty() && !this.hand.isHandFull()) {
                    this.hand.setIngredient(ingredientTool.takeIngredient());
                    return true;
                } else {
                    return false;
                }
            } else if (this.hand.isDish() && ingredientTool.toString().equals("trashCan")) {
                this.hand.setDish(null);
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * Use a DishTool
     * @param dishTool the tool used
     * @see DishTool
     * @return <code>true</code> if the operation was successful
     *         <code>false</code> otherwise
     */
    public boolean useDishTool(DishTool dishTool) {
        if (dishTool.isUsable(this.posX, this.posY)) {
            if (dishTool.toString().equals("workplan") && this.hand.isIngredient() ) {
                if (dishTool.getDishSize() <= 7) {
                    ((Workplan) dishTool).addIngredient(this.hand.getIngredient());
                    this.hand.setIngredient(null);
                    return true;
                } else {
                    return false;
                }
            } else if (!this.hand.isIngredient()) {
                if (this.hand.isDish() && dishTool.isEmpty()) {
                    dishTool.addDish(this.hand.getDish());
                    dishTool.use();
                    this.hand.setDish(null);
                    return true;
                } else if (!this.hand.isHandFull() && !dishTool.isEmpty()) {
                    this.hand.setDish(dishTool.takeDish());
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     *
     * @return posX the X axis position of the pizzaiolo
     */
    public int getPosX() {
        return posX;
    }

    /**
     *
     * @return posX the Y axis position of the pizzaiolo
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets the pizzaiolo's position
     * @param x the X axis position
     * @param y the Y axis position
     */
    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    /**
     *
     * @return Hand
     */
    public Hand getHand() {
        return this.hand;
    }
}
