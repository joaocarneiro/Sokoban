package isel.poo.sokoban.model;

public class Cell {

    private int l;
    private int c;

    public Cell(int l, int c){
        this.l=l;
        this.c=c;
    }

    public int getLine(){
        return this.l;
    }
    public int getCol(){
        return this.c;
    }
    public void setLine(int line){
        this.l=line;
    }
    public void setCol(int col){
        this.c=col;
    }


}
