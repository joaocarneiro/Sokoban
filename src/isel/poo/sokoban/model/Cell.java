package isel.poo.sokoban.model;
public class Cell {

    private int l;
    private int c;
    private char type;

    public Cell(int l, int c){
        this.l=l;
        this.c=c;
    }

    public Cell(int l, int c, char type){
        this.l=l;
        this.c=c;
        this.type=type;
    }

    public Cell(){}

    public int getLine(){
        return this.l;
    }

    public int getCol(){
        return this.c;
    }

    public char getType() {return type;}

    public void setLine(int line){
        this.l=line;
    }

    public void setCol(int col){
        this.c=col;
    }

    public void setType(char type) {this.type = type;}
}
