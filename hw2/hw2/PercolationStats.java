package hw2;
import edu.princeton.cs.introcs.*;
public class PercolationStats {
    double[] threshold;
    int times;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if(N <= 0 || T <= 0) {
            throw new IllegalArgumentException("The input should be greater than zero.");
        }
        Percolation perc;
        int num;
        threshold = new double[T];
        times = T;
        for (int i = 0; i < T; i ++) {
            perc = pf.make(N);
            num = 0;
            while (!perc.percolates()) {
                int randR = StdRandom.uniform(N);
                int randC = StdRandom.uniform(N);
                if (perc.isOpen(randR,randC)) {
                    continue;
                }
                perc.open(randR, randC);
                num++;
            }
            threshold[i] = num * 1.0 / (N * N);
        }


    }   // perform T independent experiments on an N-by-N grid

    public double mean() {
        return StdStats.mean(threshold);
    } // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(threshold);
    } // sample standard deviation of percolation threshold
    public double confidenceLow() {
        double low;
        low = mean() - 1.96 * stddev() / Math.sqrt(times);
        return low;
    }                                // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        double high;
        high = mean() + 1.96 * stddev() / Math.sqrt(times);
        return high;
    } // high endpoint of 95% confidence interval
}
