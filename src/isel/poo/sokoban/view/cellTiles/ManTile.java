package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.actors.ManCell;
import isel.poo.sokoban.view.CellTile;

public class ManTile extends CellTile{

    public ManTile(){
        setSize(CellTile.SIDE, CellTile.SIDE);
    }

    @Override
    public void paint(){
        Console.setBackground(Console.YELLOW);
        Console.setForeground(Console.BLACK);
        print(0,0, ManCell.getMAN_CHARACTER()); print(0,1, ManCell.getMAN_CHARACTER());
        print(1,0, ManCell.getMAN_CHARACTER()); print(1,1, ManCell.getMAN_CHARACTER());
    }
}