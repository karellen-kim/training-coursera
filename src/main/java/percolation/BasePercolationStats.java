package percolation;

public interface BasePercolationStats {
    double mean();
    double stddev();
    double confidenceLo();
    double confidenceHi();
}
