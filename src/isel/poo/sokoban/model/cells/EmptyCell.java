package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Cell;

public class EmptyCell extends Cell {

    private static final char EMPTY_CHARACTER = '.';

    public EmptyCell(){}

    public static char getEMPTY_CHARACTER(){
        return EMPTY_CHARACTER;
    }

    public static Cell getEmptyCell(){
        return null;
    }

}
