package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.ObjectiveCell;
import isel.poo.sokoban.view.CellTile;

public class ObjectiveTile extends CellTile {

    public ObjectiveTile() {
        super();
    }

    @Override
    public void paint() {
        Console.setBackground(Console.WHITE);
        Console.setForeground(Console.GREEN);
        print(0, 0, ObjectiveCell.getOBJECTIVE_CHARACTER());
        print(0, 1, ObjectiveCell.getOBJECTIVE_CHARACTER());
        print(1, 0, ObjectiveCell.getOBJECTIVE_CHARACTER());
        print(1, 1, ObjectiveCell.getOBJECTIVE_CHARACTER());
    }
}
