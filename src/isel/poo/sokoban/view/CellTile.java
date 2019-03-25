package isel.poo.sokoban.view;

import isel.poo.console.tile.Tile;
import isel.poo.sokoban.model.Cell;

public class CellTile extends Tile {
    private static Tile tiles;
    public static int SIDE;

    public static Tile tileOf( Cell cell ){
        Tile tile=tiles;
        return tile;
    }
}
