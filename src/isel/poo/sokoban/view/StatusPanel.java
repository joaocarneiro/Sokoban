package isel.poo.sokoban.view;

import isel.leic.pg.Console;
import isel.poo.console.FieldView;
import isel.poo.console.ParentView;
import jdk.net.SocketFlow;

import java.awt.*;
import java.lang.reflect.Field;

import static isel.leic.pg.Console.*;
import static java.awt.Color.*;

public class StatusPanel extends ParentView {

    public static int WIDTH=5;
    private int WIN_WIDTH;
    private int levelNumber;
    private int remainingBoxes;
    private int moves;
    private ParentView panel;
    private FieldView fieldLevel;
    private FieldView fieldMoves;
    private FieldView fieldBoxes;
    private FieldView fieldCursor;
    private FieldView fieldEsc;
    private FieldView fieldS;

    public StatusPanel(int WIN_WIDTH) {
        this.WIN_WIDTH=WIN_WIDTH;
        initStatusPanel();
    }

    public void write(int line, int col, String text, int foreground, int background) {
        cursor(line,col);
        color(foreground,background);
        Console.print(text);
    }

    private void initStatusPanel(){
        panel = new ParentView(0,WIN_WIDTH-2,17,7, Console.DARK_GRAY);
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

        write(0,4,"\nCursor",Console.YELLOW, Console.DARK_GRAY);
        write(0,4,"\nmove",Console.WHITE, Console.DARK_GRAY);
        write(0,4,"\nEsc",Console.YELLOW, Console.DARK_GRAY);
        write(0,4,"\nfinish",Console.WHITE, Console.DARK_GRAY);
        write(0,4,"\nS",Console.YELLOW, Console.DARK_GRAY);
        write(0,4,"\nstart",Console.WHITE, Console.DARK_GRAY);
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
