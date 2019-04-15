package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Cell;

public class ObjectiveCell extends Cell {

    private static final char OBJECTIVE_CHARACTER = '+';

    public ObjectiveCell(){}

    public ObjectiveCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

//    @Override
//    public void updateCell(char typeAbove, char typeBelow) {
//        this.cellBelow = cellAbove;
//    }

    public static char getOBJECTIVE_CHARACTER() {
        return OBJECTIVE_CHARACTER;
    }
}
