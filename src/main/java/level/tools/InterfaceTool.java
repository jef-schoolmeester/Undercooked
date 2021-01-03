package level.tools;

/**
 * A interface with the basic methods required for tools
 * @see IngredientTool
 * @see DishTool
 *
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public interface InterfaceTool {
    boolean isUsable(int posX, int posY);
    boolean isEmpty();
    String getImagePath();
    String toString();
}
