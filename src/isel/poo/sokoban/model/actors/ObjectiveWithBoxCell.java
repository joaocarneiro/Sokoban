package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Cell;

public class ObjectiveWithBoxCell extends Cell {

    private static final char OBJECTIVEWITHBOX_CHARACTER = 'o';

    public ObjectiveWithBoxCell(){}

    public ObjectiveWithBoxCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

//    @Override
//    public void updateCell(char typeAbove, char typeBelow) {
//        this.cellBelow = cellAbove;
//    }

    public static char getOBJECTIVEWITHBOX_CHARACTER() {
        return OBJECTIVEWITHBOX_CHARACTER;
    }
}
