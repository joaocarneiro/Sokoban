package isel.poo.sokoban.model;

import isel.poo.sokoban.model.actors.BoxCell;
import isel.poo.sokoban.model.actors.ManCell;
import isel.poo.sokoban.model.actors.ObjectiveWithBoxCell;
import isel.poo.sokoban.model.cells.*;
import isel.poo.sokoban.view.cellTiles.*;

public class Cell {

    protected Cell cellAbove;
    protected Cell cellBelow;
    private int l;
    private int c;
    protected char typeAbove;
    protected char typeBelow;

    public Cell() {
    }

    public Cell(char typeAbove, char typeBelow) {
        this.typeAbove = typeAbove;
        this.typeBelow = typeBelow;
    }

    public Cell(int l, int c, char typeAbove, char typeBelow) {
        this.l = l;
        this.c = c;
        this.typeAbove = typeAbove;
        this.typeBelow = typeBelow;
    }

    public Cell updateCell(char typeAbove, char typeBelow) {
        Cell cell = new Cell(l,c,typeAbove,typeBelow);
        return cell;
    }

    public  Cell getCell(char type){
        if((type=='B'||type=='o')&&typeBelow=='*')
            return new ObjectiveWithBoxCell();
        switch (type) {
            case '.':
                return new EmptyCell();
            case ' ':
                return new FloorCell();
            case 'X':
                return new ObstacleCell();
            case 'H':
                return new HoleCell();
            case '*':
                return new ObjectiveCell();
            case '@':
                return new ManCell();
            case 'o':
            case 'B':
                return new BoxCell();
            default:
                return new EmptyCell();
        }
    }

    public Cell getCellAbove() {
        return cellAbove;
    }

    public Cell getCellBelow() {
        return cellBelow;
    }

    public char getTypeAbove() {
        return this.typeAbove;
    }

    public char getTypeBelow() {
        return this.typeBelow;
    }

    public void setTypeAbove(char typeAbove) {
        this.typeAbove = typeAbove;
    }

    public void setTypeBelow(char typeBelow) {
        this.typeBelow = typeBelow;
    }
}
