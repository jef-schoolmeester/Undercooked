package level;

import level.pizzaiolo.Pizzaiolo;
import level.tools.Tile;
import level.Table;

import java.util.ArrayList;

public class Level {
    private int level;
    private Difficulty difficulty;
    private ArrayList<ArrayList<Tile>> table;
    private Pizzaiolo pizzaiolo;

    public Level(int level, Difficulty difficulty){
        this.level=level;
        this.difficulty=difficulty;
    }


    public Level(){
        this.table = new ArrayList<>();
        pizzaiolo = new Pizzaiolo();
    }

}