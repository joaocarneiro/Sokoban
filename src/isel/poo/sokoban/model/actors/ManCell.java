package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Cell;

public class ManCell extends Cell {

    private static final char MAN_CHARACTER = '@';

    public ManCell(){}

    public ManCell(char typeAbove, char typeBelow) {
        super(typeAbove,typeBelow);
    }

    public static char getMAN_CHARACTER() {
        return MAN_CHARACTER;
    }
}
