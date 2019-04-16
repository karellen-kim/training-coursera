package percolation.v1;

import percolation.BasePercolationStats;

public class PercolationStats implements BasePercolationStats {

    Percolation percolation;

    public PercolationStats(int n, int trials) {
        percolation = new Percolation(n);
    }

    @Override
    public double mean() {
        return 0;
    }

    @Override
    public double stddev() {
        return 0;
    }

    @Override
    public double confidenceLo() {
        return 0;
    }

    @Override
    public double confidenceHi() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
