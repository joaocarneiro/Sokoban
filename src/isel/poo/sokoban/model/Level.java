package isel.poo.sokoban.model;

import isel.poo.sokoban.model.actors.BoxCell;
import isel.poo.sokoban.model.actors.ManCell;
import isel.poo.sokoban.model.actors.ObjectiveWithBoxCell;
import isel.poo.sokoban.model.cells.*;

public class Level {

    private int levelNumber;
    private int height;
    private int width;
    private int line;
    private int col;
    private int boxes;
    private int moves;
    private Observer observer;
    private boolean start;
    private boolean manIsDead = false;
    private boolean isFinished = false;
    private Cell[][] cells;
    private int lineMan = 0, colMan = 0;
    private int initialLineMan = 0, initialColMan = 0;
    private boolean found;
    private int startingBoxes;

    public Level(int levelNumber, int height, int width) {
        this.levelNumber = levelNumber;
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public interface Observer {
        void cellUpdated(int l, int c, Cell cell);
        void cellReplaced(int l, int c, Cell cell);
    }

    void init(Game game) {
        startingBoxes();
        isFinished();
        manIsDead();
        print();
    }

    public void moveMan(Dir dir) {
        getManInitialPosition();
        switch (dir) {
            case UP:
                moveAgainst(dir);
                break;
            case DOWN:
                moveAgainst(dir);
                break;
            case RIGHT:
                moveAgainst(dir);
                break;
            case LEFT:
                moveAgainst(dir);
                break;
        }
    }

    public void getManInitialPosition() {
        found = false;
        if (lineMan == 0 && colMan == 0) {
            for (line = 0; line < cells.length && !found; ++line) {
                for (col = 0; col < cells[line].length && !found; ++col)
                    if (cells[line][col].getTypeAbove() == '@') {
                        found = true;
                        lineMan = line;
                        colMan = col;
                        initialLineMan=lineMan;
                        initialColMan=colMan;
                    }
            }
        }
    }

    public void moveAgainst(Dir dir) {
        char type = cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].getTypeAbove();
        switch (type) {
            case ' ':
                movedAgainstFloor(dir);
                break;
            case 'B':
                movedAgainstBox(dir);
                break;
            case 'H':
                movedAgainstHole(dir);
                break;
            case '*':
                movedAgainstObjective(dir);
                break;
        }
    }

    private void checkForVictory(){
        if(checkBoxesInPlace()){
            isFinished=true;
            print();
            System.out.println();
        }
    }

    public void movedAgainstFloor(Dir dir){
        cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
        cells[lineMan][colMan].setTypeBelow(' ');
        cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
        observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
        observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
        lineMan += dir.AddToLine();
        colMan += dir.AddToCol();
        moves += 1;
        print();
        System.out.println();
    }

    public void movedAgainstBox(Dir dir){
        char type;
        switch (dir){
            case UP:
            case DOWN:
                type = cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].getTypeAbove();
                if(type==' '){
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeBelow(' ');
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeAbove('B');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
                    observer.cellReplaced(lineMan + dir.AddToLine()*2,colMan + dir.AddToCol(), new BoxCell().updateCell(BoxCell.getBOX_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(cells[lineMan][colMan].getTypeBelow(),FloorCell.getFLOOR_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='H'){
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeBelow(' ');
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
                    observer.cellReplaced(lineMan + dir.AddToLine()*2,colMan + dir.AddToCol(), new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='*'){
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeBelow(type);
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeAbove('B');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
                    observer.cellReplaced(lineMan + dir.AddToLine()*2,colMan + dir.AddToCol(), new ObjectiveWithBoxCell().updateCell(ObjectiveWithBoxCell.getOBJECTIVEWITHBOX_CHARACTER(), ObjectiveCell.getOBJECTIVE_CHARACTER()));
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    checkForVictory();
                    System.out.println();
                }
                break;
            case LEFT:
            case RIGHT:
                type = cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].getTypeAbove();
                if(type==' '){
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeBelow(type);
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeAbove('B');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
//                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol()*2, new BoxCell().updateCell(BoxCell.getBOX_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
//                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(cells[lineMan][colMan].getTypeBelow(),FloorCell.getFLOOR_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='H'){
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeBelow(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol()*2, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='*') {
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeBelow(type);
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeAbove('B');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
//                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol()*2, new ObjectiveWithBoxCell().updateCell(ObjectiveWithBoxCell.getOBJECTIVEWITHBOX_CHARACTER(), ObjectiveCell.getOBJECTIVE_CHARACTER()));
//                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),FloorCell.getFLOOR_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    checkForVictory();
                    System.out.println();
                }
                break;
        }
    }

    public void movedAgainstHole(Dir dir){
        switch (dir) {
            case UP:
            case DOWN:
            case RIGHT:
            case LEFT:
                cells[lineMan][colMan].setTypeAbove(' ');
                cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('H');
                observer.cellUpdated(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new HoleCell().updateCell(HoleCell.getHOLE_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                observer.cellReplaced(lineMan, colMan, new FloorCell().updateCell(FloorCell.getFLOOR_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                lineMan += dir.AddToLine();
                colMan += dir.AddToCol();
                moves += 1;
                isFinished = true;
                manIsDead = true;
                print();
                System.out.println();
                break;
        }
    }

    public void movedAgainstObjective(Dir dir){
        switch (dir) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                if(cells[lineMan][colMan].getTypeBelow()=='*'){
                    cells[lineMan][colMan].setTypeAbove('*');
                    cells[lineMan][colMan].setTypeBelow(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeBelow('*');
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),ObjectiveCell.getOBJECTIVE_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new ObjectiveCell().updateCell(ObjectiveCell.getOBJECTIVE_CHARACTER(),EmptyCell.getEMPTY_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                else if(cells[lineMan][colMan].getTypeBelow()!='*'){
                    cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                    cells[lineMan][colMan].setTypeBelow(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeBelow('*');
                    observer.cellReplaced(lineMan + dir.AddToLine(),colMan + dir.AddToCol(), new ManCell().updateCell(ManCell.getMAN_CHARACTER(),ObjectiveCell.getOBJECTIVE_CHARACTER()));
                    observer.cellReplaced(lineMan, colMan, new Cell(cells[lineMan][colMan].getTypeBelow(), EmptyCell.getEMPTY_CHARACTER()));
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
        }
    }

    public void startingBoxes(){
        boxes=0;
        for (line = 0; line < cells.length && !start; ++line) {
            for (col = 0; col < cells[line].length; ++col) {
                if (cells[line][col].getTypeAbove() == 'B') {
                    boxes++;
                }
            }
        }
        startingBoxes=boxes;
        start=true;
    }

    public int getMoves() {
        return this.moves;
    }

    public int getRemainingBoxes() {
        return this.boxes;
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

    public boolean manIsDead() {
        return this.manIsDead;
    }

    public boolean checkBoxesInPlace(){
        int boxesInPlace=0;
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                if(cells[i][j].getTypeAbove()=='B'&&cells[i][j].getTypeBelow()=='*')
                    boxesInPlace++;
            }
        }
        if(boxesInPlace==boxes){
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void reset() {
        moves=0;
        start=false;
        boxes=startingBoxes;
        cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
        cells[lineMan][colMan].setTypeBelow(' ');
        lineMan=initialLineMan;
        colMan=initialColMan;
        cells[lineMan][colMan].setTypeAbove(' ');
        cells[lineMan][colMan].setTypeBelow(' ');
    }

    public Cell getCell(int line, int col) {
        return cells[line][col];
    }

    public void put(int line, int col, char type) {
        if(cells[line][col]==null)
            cells[line][col] = new Cell(line, col, type, ' ');
        else
            cells[line][col] = new Cell(line, col, type, cells[line][col].getTypeAbove());
    }

    public void print() {
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                System.out.print(cells[i][j].getTypeAbove());
            }
            System.out.println();
        }
    }
}
