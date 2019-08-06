package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.*;

public class Percolation {
    boolean[] flag;
    static int dim;
    WeightedQuickUnionUF grid;
    WeightedQuickUnionUF grid2;
    int numOfOpenSite;
    public Percolation(int N) {
        dim = N;
        flag = new boolean[dim * dim];
        grid = new WeightedQuickUnionUF(dim * dim + 2);
        grid2 = new WeightedQuickUnionUF(dim * dim + 1);
        for (int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                int num = xyTo1D(r, c);
                flag[num] = false;
            }
        }
        numOfOpenSite = 0;
    }              // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("The input should be non-negative.");
        }
        if (row >= dim || col >= dim ) {
            throw  new IndexOutOfBoundsException("The input is out of bound.");
        }
        int num = xyTo1D(row, col);
        flag[num] = true;
        numOfOpenSite++;
        if ((num + 1 < dim * dim) && (col < dim - 1) && isOpen(row, col + 1) ) {
            grid.union(num, num + 1);
            grid2.union(num, num + 1);

        }
        if ((num -1 >= 0) && (col >= 1) && isOpen(row, col - 1)) {
            grid.union(num, num - 1);
            grid2.union(num, num - 1);
        }
        if ((num - dim >= 0) && (row >= 1) && isOpen(row - 1, col)) {
            grid.union(num,  num - dim);
            grid2.union(num,  num - dim);
        }
        if ((num + dim < dim * dim) && (row < dim - 1) && isOpen(row + 1, col)) {
            grid.union(num, num + dim);
            grid2.union(num, num + dim);
        }
        if (num < dim) {
            grid.union(num, dim * dim);
            grid2.union(num, dim * dim);
        }
        if(num >= dim * (dim - 1)) {
            grid.union(num, dim * dim + 1);
        }


    }      // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("The input should be non-negative.");
        }
        if (row >= dim || col >= dim ) {
            throw  new IndexOutOfBoundsException("The input is out of bound.");
        }
        int num = xyTo1D(row, col);
        return flag[num];
    } // is the site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("The input should be non-negative.");
        }
        if (row >= dim || col >= dim ) {
            throw  new IndexOutOfBoundsException("The input is out of bound.");
        }
        int num = xyTo1D(row, col);

        return grid2.connected(dim * dim, num);

    } // is the site (row, col) full?

    public int numberOfOpenSites() {
        return numOfOpenSite;
    }           // number of open sites
    public boolean percolates() {
        return grid.connected(dim * dim, dim * dim + 1);
    }// does the system percolate?

    public int xyTo1D (int r, int c) {
        return dim * r + c;
    }

    public static void main(String[] args) {

    }  // use for unit testing (not required, but keep this here for the autograder)

}
