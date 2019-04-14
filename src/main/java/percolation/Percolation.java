package percolation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Percolation {
    int size;
    int[] grid;
    boolean[] opened;
    int numberOfOpenSites;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        size = n;
        grid = new int[n * n];
        opened = new boolean[n * n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                grid[getIndex(i, j)] = getIndex(i, j);
                opened[getIndex(i, j)] = false;
            }
        }
    }

    // uinon
    // open site (row, col) if it is not open already
    public void open(int cellRow, int cellCol) {
        int row = cellRow - 1;
        int col = cellCol - 1;
        numberOfOpenSites++;
        int curIndex = getIndex(row, col);
        this.opened[curIndex] = true;

        List<Integer> opendAdjacentIndexes = getOpendAdjacentGrids(row, col);
        for (Integer adjacentIndex : opendAdjacentIndexes) {
            connect(curIndex, adjacentIndex);
        }
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

    // is site (row, col) open?
    public boolean isOpen(int cellRow, int cellCol) {
        return this.opened[getIndex(cellRow - 1, cellCol - 1)];
    }

    // is site (row, col) full? (is connected?)
    public boolean isFull(int cellRow, int cellCol) {
        int index = getIndex(cellRow - 1, cellCol - 1);
        int id = find(index);
        return this.opened[index] && id >= 0 && id < (size - 1);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return this.numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int c = 0 ; c < size ; c++) {
            boolean isFull = isFull(size - 1, c);
            if (isFull) return true;
        }
        return false;
    }

    private int getIndex(int row, int col) {
        return row * size + col;
    }

    private List<Integer> getOpendAdjacentGrids(int row, int col) {
        Stream<List<Integer>> validIndexes = Arrays.asList(
                Arrays.asList(row - 1, col),
                Arrays.asList(row + 1, col),
                Arrays.asList(row, col - 1),
                Arrays.asList(row, col + 1))
                .stream()
                .filter(item ->
                        item.get(0) >= 0 && item.get(0) < size
                                && item.get(1) >= 0 && item.get(1) < size);

        return validIndexes
                .filter(item -> this.opened[getIndex(item.get(0),item.get(1))])
                .map(item -> getIndex(item.get(0), item.get(1)))
                .collect(Collectors.toList());
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}

