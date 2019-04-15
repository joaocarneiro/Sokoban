package isel.poo.sokoban.view;

import isel.leic.pg.Console;
import isel.poo.console.FieldView;
import isel.poo.console.ParentView;

public class StatusPanel extends ParentView {

    public static int WIDTH=5;
    protected int WIN_WIDTH;
    private int levelNumber;
    private int remainingBoxes;
    private int moves;
    private ParentView panel;
    private FieldView fieldLevel;
    private FieldView fieldMoves;
    private FieldView fieldBoxes;

    public StatusPanel(int WIN_WIDTH) {
        this.WIN_WIDTH=WIN_WIDTH;
        initStatusPanel();
    }

    private void initStatusPanel(){
        panel = new ParentView(0,WIN_WIDTH-2,17,7, Console.DARK_GRAY);
        panel.repaint();

        fieldLevel = new FieldView("Level", 1,WIN_WIDTH-1, getLevelNumber()+"");
        fieldMoves = new FieldView("Moves", 4,WIN_WIDTH-1, getMoves()+"");
        fieldBoxes = new FieldView("Boxes", 7,WIN_WIDTH-1, getRemainingBoxes()+"");
    }

    public void repaint() {
        fieldLevel.setValue(getLevelNumber());
        fieldMoves.setValue(getMoves());
        fieldBoxes.setValue(getRemainingBoxes());

        panel.repaint();
        fieldLevel.repaint();
        fieldMoves.repaint();
        fieldBoxes.repaint();
    }

    public void setLevel(int levelNumber){ this.levelNumber=levelNumber; }

    public void setBoxes(int remainingBoxes){
        this.remainingBoxes=remainingBoxes;
    }

    public void setMoves(int moves){
        this.moves=moves;
    }

    public int getLevelNumber() { return levelNumber; }

    public int getRemainingBoxes() { return remainingBoxes; }

    public int getMoves() { return moves; }
}
