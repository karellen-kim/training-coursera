package percolation.v1;

import percolation.BasePercolation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Percolation implements BasePercolation {
    private int gridSize;
    private int numberOfOpenGrid;
    private int[] grid;
    private boolean[] openedGrid;

    /**
     * create n-by-n grid, with all sites blocked
     */
    public Percolation(int n) {
        init(n);
    }

    /**
     * uinon
     * open site (row, col) if it is not open already
     */
    @Override
    public void open(int row, int col) {
        openGrid(row, col);

        List<Integer> opendAdjacentIndexes = getOpendAdjacentGrids(row, col);
        for (Integer adjacentIndex : opendAdjacentIndexes) {
            connect(getIndex(row, col), adjacentIndex);
        }
    }

    /**
     * is site (row, col) open?
     */
    @Override
    public boolean isOpen(int row, int col) {
        return this.openedGrid[getIndex(row, col)];
    }

    /**
     * is site (row, col) full? (is connected?)
     */
    @Override
    public boolean isFull(int row, int col) {
        return isOpen(row, col) && isFromTop(row, col);
    }

    /**
     * number of open sites
     */
    @Override
    public int numberOfOpenSites() {
        return this.numberOfOpenGrid;
    }

    /**
     * does the system percolate?
     */
    @Override
    public boolean percolates() {
        for (int c = 0; c < gridSize; c++) {
            boolean isFull = isFull(gridSize, c + 1);
            if (isFull) return true;
        }
        return false;
    }

    private void init(int n) {
        gridSize = n;
        grid = new int[n * n];
        openedGrid = new boolean[n * n];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                grid[getIndex(i, j)] = getIndex(i, j);
                openedGrid[getIndex(i, j)] = false;
            }
        }
    }

    private void openGrid(int row, int col) {
        numberOfOpenGrid++;
        int curIndex = getIndex(row, col);
        this.openedGrid[curIndex] = true;
    }

    private void connect(int p, int q) {
        int qId = find(p);
        int pId = find(q);

        if (pId <= qId) {
            this.grid[qId] = pId;
        } else {
            this.grid[pId] = qId;
        }
    }

    private int find(int index) {
        int curIndex = index;
        while (this.grid[curIndex] != curIndex) {
            curIndex = this.grid[curIndex];
        }
        return curIndex;
    }

    private int getIndex(int row, int col) {
        return (row - 1) * gridSize + (col - 1);
    }

    private List<Integer> getOpendAdjacentGrids(int row, int col) {
        Stream<List<Integer>> validIndexes = Arrays.asList(
                Arrays.asList(row - 1, col),
                Arrays.asList(row + 1, col),
                Arrays.asList(row, col - 1),
                Arrays.asList(row, col + 1))
                .stream()
                .filter(item ->
                        item.get(0) >= 1 && item.get(0) <= gridSize
                                && item.get(1) >= 1 && item.get(1) <= gridSize);

        return validIndexes
                .filter(item -> this.openedGrid[getIndex(item.get(0), item.get(1))])
                .map(item -> getIndex(item.get(0), item.get(1)))
                .collect(Collectors.toList());
    }

    private boolean isFromTop(int row, int col) {
        int id = find(getIndex(row, col));
        return id >= 0 && id < gridSize;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}

