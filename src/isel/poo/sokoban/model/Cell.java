package isel.poo.sokoban.model;
public class Cell {

    private int l;
    private int c;
    private char typeAbove;
    private char typeBelow;

    public Cell(int l, int c){
        this.l=l;
        this.c=c;
    }

    public Cell(int l, int c, char typeAbove, char typeBelow){
        this.l=l;
        this.c=c;
        this.typeAbove=typeAbove;
        this.typeBelow=typeBelow;
    }

    public int getLine(){
        return this.l;
    }

    public int getCol(){
        return this.c;
    }

    public char getTypeAbove() {return this.typeAbove;}

    public char getTypeBelow() {return this.typeBelow;}

    public void setLine(int line){
        this.l=line;
    }

    public void setCol(int col){
        this.c=col;
    }

    public void setTypeAbove(char typeAbove) {this.typeAbove = typeAbove;}

    public void setTypeBelow(char typeBelow) {this.typeBelow = typeBelow;}
}
