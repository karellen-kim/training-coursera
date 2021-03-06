package percolation;

public class PercolationStats {
    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        // java.lang.IllegalArgumentException if either n ≤ 0 or trials ≤ 0.
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
    }
    // sample mean of percolation threshold
    public double mean() {
        return 0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0;
    }

    // test client (described below)
    public static void main(String[] args) {

    }
}
