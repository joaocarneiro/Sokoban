package isel.poo.sokoban.model;

public enum Dir {

    UP(-1,0),
    DOWN(1,0),
    RIGHT(0,1),
    LEFT(0,-1);

    private int addToLine;
    private int addToCol;

    Dir(int addToLine, int addToCol){
        this.addToLine=addToLine;
        this.addToCol=addToCol;
    }

    public int AddToLine(){
        return addToLine;
    }

    public int AddToCol(){
        return addToCol;
    }
}
