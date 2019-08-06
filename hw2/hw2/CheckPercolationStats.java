package hw2;

public class CheckPercolationStats {
    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats stats = new PercolationStats(20, 40, pf);
        double mean = stats.mean();
        System.out.println(mean);
    }
}
