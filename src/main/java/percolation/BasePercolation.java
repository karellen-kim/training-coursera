package percolation;

public interface BasePercolation {
    void open(int cellRow, int cellCol);
    boolean isOpen(int cellRow, int cellCol);
    boolean isFull(int row, int col);
    int numberOfOpenSites();
    boolean percolates();
}
