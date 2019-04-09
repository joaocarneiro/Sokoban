package isel.poo.sokoban.model;

import isel.leic.pg.Console;
import isel.poo.console.ParentView;
import isel.poo.console.View;
import isel.poo.console.Window;
import isel.poo.sokoban.ctrl.Sokoban;

import static isel.leic.pg.Console.*;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_A;

public class Level {

    private int levelNumber;
    private int height;
    private int width;
    private int line;
    private int col;
    private int remainingBoxes;
    private int moves;
    private Observer observer;
    private boolean manIsDead = false;
    private boolean isFinished = false;
    int previousLine=0;
    private Cell[][] cells;
    int lineMan=0, colMan=0;

    public Level(int levelNumber, int height, int width) {
        this.levelNumber = levelNumber;
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
    }

    public void setObserver(Observer updater) {
        this.observer=updater;
    }

    public interface Observer {
        void cellUpdated(int l, int c, Cell cell);

        void cellReplaced(int l, int c, Cell cell);
    }

    void init(Game game) {
        print();
    }

    public void movement(Dir dir){
        if (cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].getType() == ' ') {
            cells[lineMan][colMan].setType(' ');
            cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setType('@');
            lineMan+=dir.AddToLine();
            colMan+=dir.AddToCol();
            print();
            System.out.println();
        }
    }

    public void moveMan(Dir dir) {
        boolean found=false;
        if(lineMan==0&&colMan==0) {
            for (line = 0; line < cells.length && !found; ++line) {
                for (int col = 0; col < cells[line].length && !found; ++col)
                    if (cells[line][col].getType() == '@') {
                        found = true;
                        lineMan = cells[line][col].getLine();
                        colMan = cells[line][col].getCol();
                    }
            }
        }
        switch (dir) {
            case UP:
                movement(dir);
                break;
            case DOWN:
                movement(dir);
                break;
            case RIGHT:
                movement(dir);
                break;
            case LEFT:
                movement(dir);
                break;
        }
    }

    public int getMoves() {
        return this.moves;
    }

    public int getRemainingBoxes() {
        return this.remainingBoxes;
    }

    public int getNumber() {
        return this.levelNumber;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public Cell getCell(int line, int col) {
        Cell cell = new Cell(line, col);
        return cell;
    }

    public boolean manIsDead() {
        return this.manIsDead;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void reset() {
    }

    public void put(int line, int col, char type) {
        cells[line][col] = new Cell(col, line, type);
    }

    public void print(){
        for(int i=0;i<cells.length;++i){
            for (int j=0;j<cells[i].length;++j){
                System.out.print(cells[i][j].getType());
            }
            System.out.println();
        }
    }
}
