package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.FloorCell;
import isel.poo.sokoban.view.CellTile;

public class FloorTile extends CellTile {

    public FloorTile() {
        super();
    }

    @Override
    public void paint() {
        Console.setBackground(Console.WHITE);
        Console.setForeground(Console.WHITE);
        print(0, 0, FloorCell.getFLOOR_CHARACTER());
        print(0, 1, FloorCell.getFLOOR_CHARACTER());
        print(1, 0, FloorCell.getFLOOR_CHARACTER());
        print(1, 1, FloorCell.getFLOOR_CHARACTER());
    }
}
