package level.tools;

public class PizzaRoll extends IngredientTool {
    public PizzaRoll(int posX, int posY) {
        super(posX, posY);
    }

    public String toString() {
        return "pizzaRoll";
    }

    public String imgPath() {
        return "/IB/tools/pizzaRoll.png";
    }
}
