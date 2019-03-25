package isel.poo.sokoban.view;

import isel.poo.console.ParentView;

public class StatusPanel extends ParentView {

    public static int WIDTH;
    private int levelNumber;
    private int remainingBoxes;
    private int moves;

    public StatusPanel(int WIN_WIDTH){
        this.width=WIN_WIDTH;
    }

    public void setLevel(int levelNumber){
        this.levelNumber=levelNumber;
    }
    public void setBoxes(int remainingBoxes){
        this.remainingBoxes=remainingBoxes;
    }
    public void setMoves(int moves){
        this.moves=moves;
    }
}
