package sdp_final4;

public class LawnMower {
    private int row;
    private int column;
    private boolean[][] lawn;
    private boolean isRunning;
    private State state;

    
    public LawnMower(int numRows, int numCols) {
        row = 0;
        column = 0;
        lawn = new boolean[numRows][numCols];
        isRunning = false;
        state = new EastState(this); // set in
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    public void advance() {
        if (isRunning) {
            lawn[row][column] = true;

            // Move to next cell
            column++;
            if (column >= lawn[0].length) {
                column = 0;
                row++;
            }
            // Reset position to (0, 0) if we reach the end
            if (row >= lawn.length) {
                row = 0;
                column = 0;
            }
        }
    }

    public boolean isCut(int row, int column) {
        return lawn[row][column];
    }

    public int getRow() {
        return row;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    
    public void setState(State state) {
        this.state = state;
    }
 
    public void setRow(int row) {
        this.row = row;
    }

    public int getNumRows() {
        return lawn.length;
    }

    public int getNumCols() {
        return lawn[0].length;
    }

    public void move() {
        state.move();
    }


    public int getColumn() {
        return column;
    }
}
