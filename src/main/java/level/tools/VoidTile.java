package level.tools;

public class VoidTile extends Tile{

    public VoidTile(int posX, int posY) {
        super(posX, posY);
    }

    public String toString() {
        return "void";
    }

    public String getImagePath() {
        return "/IB/floor/void.png";
    }
}
