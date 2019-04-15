package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Cell;

public class ObjectiveWithBoxCell extends Cell {

    private static final char OBJECTIVEWITHBOX_CHARACTER = 'o';

    public ObjectiveWithBoxCell(){}

    public ObjectiveWithBoxCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

    public static char getOBJECTIVEWITHBOX_CHARACTER() {
        return OBJECTIVEWITHBOX_CHARACTER;
    }
}
