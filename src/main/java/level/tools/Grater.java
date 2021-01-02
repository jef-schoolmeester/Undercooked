package level.tools;

public class Grater extends IngredientTool {
    public Grater(int posX, int posY) {
        super(posX, posY);
    }

    public String toString() {
        return "grater";
    }

    public String getImagePath() {
        return "/IB/tools/grater.png";
    }
}