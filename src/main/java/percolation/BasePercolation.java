package percolation;

public interface BasePercolation {
    void open(int cellRow, int cellCol);
    boolean isOpen(int cellRow, int cellCol);
    int numberOfOpenSites();
    boolean percolates();
}
