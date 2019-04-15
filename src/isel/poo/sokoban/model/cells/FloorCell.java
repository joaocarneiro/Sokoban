package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Cell;

public class FloorCell extends Cell {

    private static final char FLOOR_CHARACTER = ' ';

    public FloorCell(){}

    public FloorCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

//    @Override
//    public Cell updateCell(char newType, char oldType) {
//        this.typeBelow = oldType;
//        this.typeAbove = newType;
//    }

    public static char getFLOOR_CHARACTER() {
        return FLOOR_CHARACTER;
    }
}
