package level;

import level.tools.Tile;
import level.Table;

public class Level {
    private int level;
    private Difficulty difficulty;
    private Tile[][] table;

    public Level(int level, Difficulty difficulty){
        this.level=level;
        this.difficulty=difficulty;
    }

    public void displayMap(){

    }

    public void newGame(){
        table = new Tile[10][10];
        //Pizzaiolo p = new Pizzaiolo(5,5);
    }

}