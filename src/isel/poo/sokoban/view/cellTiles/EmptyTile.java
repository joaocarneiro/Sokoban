package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.EmptyCell;
import isel.poo.sokoban.view.CellTile;

public class EmptyTile extends CellTile {

    public EmptyTile(){
        super();
    }

    @Override
    public void paint(){
        Console.setBackground(Console.BLACK);
        Console.setForeground(Console.BLACK);
        print(0,0,EmptyCell.getEMPTY_CHARACTER()); print(0,1,EmptyCell.getEMPTY_CHARACTER());
        print(1,0,EmptyCell.getEMPTY_CHARACTER()); print(1,1,EmptyCell.getEMPTY_CHARACTER());
    }
}
