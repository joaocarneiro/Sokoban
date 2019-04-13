package isel.poo.sokoban.view;

import isel.leic.pg.Console;
import isel.poo.console.tile.Tile;
import isel.poo.sokoban.model.Cell;

import java.awt.*;

public class CellTile extends Tile {
    private static Tile tile;
    public static int SIDE = 2;
    Cell cell;

    public CellTile(Cell cell){
        this.tile=tile;
    }

    public CellTile(){}

    public static Tile tileOf( Cell cell ){
        tile = new CellTile(cell);
        return tile;
    }
    @Override
    public void init(){

    }

}
