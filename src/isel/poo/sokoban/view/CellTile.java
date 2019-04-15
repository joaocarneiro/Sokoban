package isel.poo.sokoban.view;

import isel.poo.console.tile.Tile;
import isel.poo.sokoban.model.Cell;
import isel.poo.sokoban.view.cellTiles.*;

public class CellTile extends Tile {
    public static int SIDE = 2;
    public static Cell cell;

    public CellTile() {
        setSize(CellTile.SIDE, CellTile.SIDE);
    }

    public static Tile tileOf(Cell cell) {
        if(cell.getTypeBelow()=='*' && cell.getTypeAbove()=='B')
            return new ObjectiveWithBoxTile();
        else {
            switch (cell.getTypeAbove()) {
                case ' ':
                    return new FloorTile();
                case 'X':
                    return new ObstacleTile();
                case 'H':
                    return new HoleTile();
                case '*':
                    return new ObjectiveTile();
                case '@':
                    return new ManTile();
                case 'B':
                    return new BoxTile();
                default:
                    return new EmptyTile();
            }
        }
    }
}
