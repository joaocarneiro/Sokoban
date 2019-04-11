package isel.poo.sokoban.model;

public class Level {

    private int levelNumber;
    private int height;
    private int width;
    private int line;
    private int col;
    private int remainingBoxes;
    private int moves;
    private Observer observer;
    private boolean start;
    private boolean manIsDead = false;
    private boolean isFinished = false;
    private Cell[][] cells;
    private int lineMan = 0, colMan = 0;

    public Level(int levelNumber, int height, int width) {
        this.levelNumber = levelNumber;
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
    }

    public void setObserver(Observer updater) {
        observer = updater;
    }

    public interface Observer {
        void cellUpdated(int l, int c, Cell cell);

        void cellReplaced(int l, int c, Cell cell);
    }

    void init(Game game) {
        isFinished();
        manIsDead();
        startingBoxes();
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
        boolean found = false;
        if (lineMan == 0 && colMan == 0) {
            for (line = 0; line < cells.length && !found; ++line) {
                for (col = 0; col < cells[line].length && !found; ++col)
                    if (cells[line][col].getTypeAbove() == '@') {
                        found = true;
                        lineMan = cells[line][col].getLine();
                        colMan = cells[line][col].getCol();
                    }
            }
        }
    }

    public void startingBoxes(){
        remainingBoxes=0;
        for (line = 0; line < cells.length && !start; ++line) {
            for (col = 0; col < cells[line].length; ++col) {
                if (cells[line][col].getTypeAbove() == 'B') {
                    remainingBoxes++;
                }
            }
        }
        start=true;
    }

    public void moveAgainst(Dir dir) {
        char type = cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].getTypeAbove();
        switch (type) {
            case ' ':
                cells[lineMan][colMan].setTypeAbove(cells[lineMan][colMan].getTypeBelow());
                cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                lineMan += dir.AddToLine();
                colMan += dir.AddToCol();
                moves += 1;
                print();
                System.out.println();
                break;
            case 'B':
                checkBoxSurroundings(dir);
                break;
            case 'H':
                pitOfDeath(dir);
                break;
            case '*':
                specialPlace(dir);
                //IMPLEMENTAR O ASTERISCO COM O HOMEM POR CIMA
                //TEM DE SE FAZER O SETBELOW COM O ASTERISCO E SETABOVE COM O HOMEM
                //ASSIM QUE SAIR, O SETBELOW RETORNA AO SETABOVE
                break;
        }
    }

    public void specialPlace(Dir dir){
        char type;
        switch (dir) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                type = cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].getTypeAbove();
                if(type=='@') {
                    cells[lineMan][colMan].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('*');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='B'){
                    cells[lineMan][colMan].setTypeAbove('B');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('*');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type==' '){
                    cells[lineMan][colMan].setTypeAbove('*');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove(' ');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                break;
        }
    }

    public void pitOfDeath(Dir dir){
        char type;
        switch (dir) {
            case UP:
            case DOWN:
            case RIGHT:
            case LEFT:
                type = cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].getTypeAbove();
                if(type=='H'){
                    cells[lineMan][colMan].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('H');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    isFinished=true;
                    manIsDead=true;
                    print();
                    System.out.println();
                }
                break;
        }
    }

    public void checkBoxSurroundings(Dir dir){
        char type;
        switch (dir){
            case UP:
            case DOWN:
                type = cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].getTypeAbove();
                if(type==' '){
                    cells[lineMan][colMan].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeAbove('B');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='H'){
                    cells[lineMan][colMan].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()*2][colMan + dir.AddToCol()].setTypeAbove(' ');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    remainingBoxes--;
                    print();
                    System.out.println();
                }
                break;
            case LEFT:
            case RIGHT:
                type = cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].getTypeAbove();
                if(type==' '){
                    cells[lineMan][colMan].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeAbove('B');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    print();
                    System.out.println();
                }
                if(type=='H'){
                    cells[lineMan][colMan].setTypeAbove(' ');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()].setTypeAbove('@');
                    cells[lineMan + dir.AddToLine()][colMan + dir.AddToCol()*2].setTypeAbove(' ');
                    lineMan += dir.AddToLine();
                    colMan += dir.AddToCol();
                    moves += 1;
                    remainingBoxes--;
                    print();
                    System.out.println();
                }
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
        if(cells[line][col]==null)
            cells[line][col] = new Cell(line, col, type,' ');
        else
            cells[line][col] = new Cell(line, col, type, cells[line][col].getTypeAbove());
    }

    public void print() {
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                System.out.print(cells[i][j].getTypeAbove()/*+"-"+cells[i][j].getTypeBelow()*/);
            }
            System.out.println();
        }
        System.out.println(getMoves());
        System.out.println(getRemainingBoxes());
    }
}
