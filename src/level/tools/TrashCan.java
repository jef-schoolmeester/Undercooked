package level.tools;

import level.reciepe.Ingredient;

public class TrashCan extends Tool{
    public TrashCan(int posX, int posY) {
        super(posX, posY);
    }


    @Override
    public boolean use() {
        return false;
    }

    public boolean addIngredient(Ingredient ingredient) {
        return true;
    }

    public Ingredient takeIngredient() {
        return null;
    }
}
