package isel.poo.sokoban.view.cellTiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.ObstacleCell;
import isel.poo.sokoban.view.CellTile;

public class ObstacleTile extends CellTile{

    public ObstacleTile() {
        super();
    }

    @Override
    public void paint() {
        Console.setBackground(Console.BROWN);
        Console.setForeground(Console.BLACK);
        print(0, 0, ObstacleCell.getOBSTACLE_CHARACTER());
        print(0, 1, ObstacleCell.getOBSTACLE_CHARACTER());
        print(1, 0, ObstacleCell.getOBSTACLE_CHARACTER());
        print(1, 1, ObstacleCell.getOBSTACLE_CHARACTER());
    }
}
