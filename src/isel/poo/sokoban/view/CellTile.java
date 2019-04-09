package isel.poo.sokoban.view;

import isel.poo.console.tile.Tile;
import isel.poo.sokoban.model.Cell;

public class CellTile extends Tile {
    private static Tile tile;
    public static int SIDE = 1;

    public CellTile(Cell cell){}

    public static Tile tileOf( Cell cell ){
        tile = new CellTile(null);
        return tile;
    }

}
