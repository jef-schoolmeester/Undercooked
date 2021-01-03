package level.tools;

/**
 * Class Tile is the base class for all the interactive Objects in a level
 * Has a X-axis position and Y-axis position
 * @see level.Level
 *
 * @author Jef
 * @since 1.0
 * @version 2.0
 */
public class Tile {


    private int posX;
    private int posY;

    /**
     * Class constructor
     * @param posX X axis tile position to be set
     * @param posY Y axis tile position to be set
     * @since 1.0
     */
    public Tile(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     *
     * @return the X-axis position
     * @since 1.0
     */
    public int getPosX() {
        return posX;
    }

    /**
     *
     * @return the Y-axis position
     * @since 1.0
     */
    public int getPosY() {
        return posY;
    }

    /**
     *
     * @return This class name
     * @since 2.0
     */
    public String toString() {
        return "tile";
    }

    /**
     *
     * @return the image path to a tile png
     * @since 2.0
     */
    public String getImagePath() {
        return "/IB/floor/tileFloor.png";
    }
}
