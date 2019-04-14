package percolation;

public class Percolation {
    boolean OPEN = true;
    boolean CLOSE = false;
    boolean[][] grid;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        grid = new boolean[n][n];

        for (int r = 0 ; r < n ; r++) {
            for (int c = 0 ; c < n ; c++) {
                grid[r][c] = CLOSE;
            }
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return false;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}

