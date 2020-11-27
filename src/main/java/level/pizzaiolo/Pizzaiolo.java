package level.pizzaiolo;
//package level;

import level.recipe.Ingredient;
import level.tools.IngredientTool;

public class Pizzaiolo {
    private int posX;
    private int posY;
    private Hand hand;

    //Pour l'instant le constructeur est à zéro, mais j'imagine que le pizzaiolo spawnera au milieu de la map, j'ai besoin de table.
    public Pizzaiolo() {
        this.posX = 0;
        this.posY = 0;
/*
        this.posX = Table.getnbCol()/2;
        this.posY = Table.getnbRow()/2;

 */
    }

    public boolean useIngredientTool(IngredientTool ingredientTool){
        if (this.hand.isHandFull() && ingredientTool.isUsable(this.posX, this.posY)){
            ingredientTool.addIngredient(this.hand.getIngredient());
            return ingredientTool.use();
        }else {
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

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
