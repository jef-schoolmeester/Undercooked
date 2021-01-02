package level.pizzaiolo;
//package level;

import level.recipe.Ingredient;
import level.tools.DishTool;
import level.tools.IngredientContainer;
import level.tools.IngredientTool;
import level.tools.Workplan;

public class Pizzaiolo {
    private int posX;
    private int posY;
    private Hand hand;


    public Pizzaiolo() {
        this.posX = 0;
        this.posY = 0;
        this.hand = new Hand();
    }

    public Pizzaiolo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hand = new Hand();
    }

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

    /*public boolean useIngredientContainer(IngredientContainer ingredientContainer){
        if (this.hand.isHandFull() && ingredientContainer.isUsable(this.posX, this.posY)) {
            ingredientContainer.addIngredient((this.hand.getIngredient()));
            return ingredientContainer.use();
        } else {
            return false;
        }
    }

    public void takeIngredientFromIngredientTool(IngredientTool ingredientTool){
        Ingredient newIngredient;
        if(ingredientTool.isUsable(this.posX, this.posY) && !this.hand.isHandFull()){
           newIngredient = ingredientTool.takeIngredient();
           this.hand.setIngredient(newIngredient);
        }
    }

    public void takeIngredientFromIngredientContainer(IngredientContainer ingredientContainer){
        Ingredient newIngredient;
        if(ingredientContainer.isUsable(this.posX, this.posY) && !this.hand.isHandFull()){
            newIngredient = ingredientContainer.takeIngredient();
            this.hand.setIngredient(newIngredient);
        }
    }*/

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public Hand getHand() {
        return this.hand;
    }
}
