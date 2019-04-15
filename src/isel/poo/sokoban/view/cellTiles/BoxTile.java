package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.actors.BoxCell;
import isel.poo.sokoban.view.CellTile;

public class BoxTile extends CellTile{

    public BoxTile(){
        setSize(CellTile.SIDE, CellTile.SIDE);
    }

    @Override
    public void paint(){
        Console.setBackground(Console.RED);
        Console.setForeground(Console.BLACK);
        print(0,0, BoxCell.getBOX_CHARACTER()); print(0,1, BoxCell.getBOX_CHARACTER());
        print(1,0, BoxCell.getBOX_CHARACTER()); print(1,1, BoxCell.getBOX_CHARACTER());
    }
}
