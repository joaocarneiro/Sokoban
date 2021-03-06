package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Cell;

public class BoxCell extends Cell {

    private static final char BOX_CHARACTER = 'o';

    public BoxCell(){}

    public BoxCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

    public static char getBOX_CHARACTER() {
        return BOX_CHARACTER;
    }
}
