package isel.poo.sokoban.view;

import isel.poo.console.ParentView;
import isel.poo.console.View;

import static isel.leic.pg.Console.GREEN;

public class StatusPanel extends ParentView {

    public static final int WIDTH = 5;
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



    private static class CounterView extends View {
        private int value = 20;
        private CounterView() { super(2,2,3,8,GREEN); repaint(); }
        @Override public void paint() { print(1,1,"val="+value); }
    };
}
