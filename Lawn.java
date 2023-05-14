package sdp_final4;

import java.util.ArrayList;
import java.util.List;

public class Lawn {
    @SuppressWarnings("unused")
	private int numRows;
    @SuppressWarnings("unused")
	private int numCols;
    private boolean[][] cells;
    private List<LawnObserver> observers;

    public Lawn(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        cells = new boolean[numRows][numCols];
        observers = new ArrayList<>();
    }

    public void addObserver(LawnObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LawnObserver observer) {
        observers.remove(observer);
    }

    public void cut(int row, int col) {
        cells[row][col] = true;
        notifyObservers(row, col, true);
    }

    public boolean isCut(int row, int col) {
        return cells[row][col];
    }

    private void notifyObservers(int row, int col, boolean isCut) {
        for (LawnObserver observer : observers) {
            observer.update(row, col, isCut);
        }
    }
}
