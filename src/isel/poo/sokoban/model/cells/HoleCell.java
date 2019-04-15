package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Cell;

public class HoleCell extends Cell {

    private static final char HOLE_CHARACTER = '~';

    public HoleCell(){}

    public HoleCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

//    @Override
//    public void updateCell(char typeAbove, char typeBelow) {
//        this.cellBelow = cellAbove;
//    }

    public static char getHOLE_CHARACTER() {
        return HOLE_CHARACTER;
    }
}
