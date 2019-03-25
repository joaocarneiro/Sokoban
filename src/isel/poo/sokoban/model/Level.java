package isel.poo.sokoban.model;

import isel.poo.sokoban.ctrl.Sokoban;

public class Level {

    private int levelNumber;
    private int height;
    private int width;

    public Level(int levelNumber, int height, int width) {
        this.levelNumber = levelNumber;
        this.height = height;
        this.width = width;
    }

    public void setObserver(Sokoban.Updater updater) {

    }

    public interface Observer {
        void cellUpdated(int l, int c, Cell cell);

        void cellReplaced(int l, int c, Cell cell);
    }

    void init(Game game) {
    }

    public void moveMan(Dir dir) {
    }

    public int getMoves() {
        return 1;
    }

    public int getRemainingBoxes() {
        return 1;
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

    public Cell getCell(int col, int line) {
        Cell cell = new Cell(line, col);
        return cell;
    }

    public boolean manIsDead() {
        return false;
    }

    public boolean isFinished() {
        return false;
    }

    public void reset() {
    }

    public void put(int line, int col, char type) {
    }
}
