package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.HoleCell;
import isel.poo.sokoban.view.CellTile;

public class HoleTile extends CellTile {

    public HoleTile() {
        super();
    }

    @Override
    public void paint() {
        Console.setBackground(Console.CYAN);
        Console.setForeground(Console.BLACK);
        print(0, 0, HoleCell.getHOLE_CHARACTER());
        print(0, 1, HoleCell.getHOLE_CHARACTER());
        print(1, 0, HoleCell.getHOLE_CHARACTER());
        print(1, 1, HoleCell.getHOLE_CHARACTER());
    }
}
