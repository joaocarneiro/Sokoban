package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Cell;

public class ObstacleCell extends Cell {

    private static final char OBSTACLE_CHARACTER = '-';

    public ObstacleCell(){}

    public ObstacleCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

//    @Override
//    public void updateCell(char typeAbove, char typeBelow) {
//        this.cellBelow = cellAbove;
//    }

    public static char getOBSTACLE_CHARACTER() {
        return OBSTACLE_CHARACTER;
    }
}
