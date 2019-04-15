package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.actors.ObjectiveWithBoxCell;
import isel.poo.sokoban.view.CellTile;

public class ObjectiveWithBoxTile extends CellTile {

    public ObjectiveWithBoxTile() {
        super();
    }

    @Override
    public void paint() {
        Console.setBackground(Console.GREEN);
        Console.setForeground(Console.BLACK);
        print(0, 0, ObjectiveWithBoxCell.getOBJECTIVEWITHBOX_CHARACTER());
        print(0, 1, ObjectiveWithBoxCell.getOBJECTIVEWITHBOX_CHARACTER());
        print(1, 0, ObjectiveWithBoxCell.getOBJECTIVEWITHBOX_CHARACTER());
        print(1, 1, ObjectiveWithBoxCell.getOBJECTIVEWITHBOX_CHARACTER());
    }
}