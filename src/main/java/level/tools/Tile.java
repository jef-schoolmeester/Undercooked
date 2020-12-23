package level.tools;

public class Tile {

    private int posX;
    private int posY;

    public Tile(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String toString() {
        return "tile";
    }
}
