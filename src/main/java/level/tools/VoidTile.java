package level.tools;

/**
 * The class VoidTile represents a tile that cannot be interacted with by the pizzaiolo
 * Extends tile
 * @see level.tools.Tile
 *
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class VoidTile extends Tile{
    /**
     *
     * @param posX X axis tile position to be set
     * @param posY Y axis tile position to be set
     * @since 1.0
     */
    public VoidTile(int posX, int posY) {
        super(posX, posY);
    }

    /**
     *
     * @return the name of this class
     * @since 1.0
     */
    public String toString() {
        return "void";
    }

    /**
     *
     * @return the image path to a void tile png
     * @since 1.0
     */
    public String getImagePath() {
        return "/IB/floor/void.png";
    }
}
