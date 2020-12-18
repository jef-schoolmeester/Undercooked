package level.pizzaiolo;
//package level;

import level.recipe.Ingredient;
import level.tools.IngredientContainer;
import level.tools.IngredientTool;

public class Pizzaiolo {
    private int posX;
    private int posY;
    private Hand hand;


    public Pizzaiolo() {
        this.posX = 0;
        this.posY = 0;
    }

    public Pizzaiolo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean useIngredientTool(IngredientTool ingredientTool){
        if (this.hand.isHandFull() && ingredientTool.isUsable(this.posX, this.posY)){
            ingredientTool.addIngredient(this.hand.getIngredient());
            return ingredientTool.use();
        }else {
            return false;
        }

    }

    public boolean useIngredientContainer(IngredientContainer ingredientContainer){
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
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
