package level.tools;

public class Tool extends Tile{

    public Tool(int posX, int posY) {
        super(posX, posY);
    }

    public boolean isUsable(int posX, int posY) {
        int xAxisDifference = Math.abs(posX - this.getPosX());
        int yAxisDifference = Math.abs(posY - this.getPosY());
        return xAxisDifference == 0 && yAxisDifference <= 1 || yAxisDifference == 0 && xAxisDifference <= 1;
    }

    public boolean use() {
        return false;
    }
}
