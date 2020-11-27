package level;

public class Table {
    private int nbCol;
    private int nbRow;

    public Table(int nbCol, int nbRow){
        this.nbCol=nbCol;
        this.nbRow=nbRow;
    }

    public int getNbCol(){
        return nbCol;
    }

    public int getNbRow() {
        return nbRow;
    }
}
