package isel.poo.sokoban.view;

import isel.leic.pg.Console;
import isel.poo.console.FieldView;
import isel.poo.console.ParentView;
import jdk.net.SocketFlow;

import java.awt.*;

import static java.awt.Color.LIGHT_GRAY;

public class StatusPanel extends ParentView {

    public static int WIDTH=5;
    private int levelNumber;
    private int remainingBoxes;
    private int moves;

    public StatusPanel(int WIN_WIDTH) {
        ParentView panel = new ParentView(0,26,17,7, Console.DARK_GRAY);
        panel.repaint();
        FieldView fieldLevel = new FieldView("Level", 1,27, getLevelNumber());
        fieldLevel.repaint();
        FieldView fieldMoves = new FieldView("Moves", 4,27, getRemainingBoxes());
        fieldMoves.repaint();
        FieldView fieldBoxes = new FieldView("Boxes", 7,27, getMoves());
        fieldBoxes.repaint();
    }

    public void setLevel(int levelNumber){ this.levelNumber=levelNumber; }

    public void setBoxes(int remainingBoxes){
        this.remainingBoxes=remainingBoxes;
    }

    public void setMoves(int moves){
        this.moves=moves;
    }

    public String getLevelNumber() { return levelNumber+""; }

    public String getRemainingBoxes() { return remainingBoxes+""; }

    public String getMoves() { return moves+""; }
}
