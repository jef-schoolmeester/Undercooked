package level.pizzaiolo;
//package level;

public class Pizzaiolo {
    private int posX;
    private int posY;

    //Pour l'instant le constructeur est à zéro, mais j'imagine que le pizzaiolo spawnera au milieu de la map, j'ai besoin de table.
    public Pizzaiolo() {
        this.posX = 0;
        this.posY = 0;
/*
        this.posX = Table.getnbCol()/2;
        this.posY = Table.getnbRow()/2;

 */
    }
}
