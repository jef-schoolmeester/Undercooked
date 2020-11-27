package level.pizzaiolo;
//package level;

import level.recipe.Ingredient;
import level.tools.Tool;

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

    public boolean useTool(Tool tool){
        if (this.hand.isHandFull() && tool.isUsable(this.posX, this.posY)){
            tool.addIngredient(this.hand.getIngredient());
            return tool.use();
        }else {
            return false;
        }

    }

    public void takeIngredientFromTool(Tool tool){
        Ingredient newIngredient;
        if(tool.isUsable(this.posX, this.posY) && !this.hand.isHandFull()){
           newIngredient = tool.takeIngredient();
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
