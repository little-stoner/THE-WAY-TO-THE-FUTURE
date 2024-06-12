
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private int n;
    private int openSites;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF fu;
    private int virtualTop;
    private int virtualBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.grid = new boolean[n * n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        fu = new WeightedQuickUnionUF(n * n + 1);
        virtualTop = n * n;
        virtualBottom = n * n + 1;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkParam(row, col);
        return grid[xy2id(row, col)];
    }

    public boolean isFull(int row, int col) {
        checkParam(row, col);
        if (!isOpen(row, col)) {
            return false;
        }
        return fu.find(xy2id(row, col)) == fu.find(virtualTop);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkParam(row, col);
        if (isOpen(row, col)) {
            return;
        }
        int pos = xy2id(row, col);
        grid[pos] = true;
        openSites++;

        if (row == 1) {
            fu.union(col - 1, virtualTop);
            uf.union(col - 1, virtualTop);
        }
        if (row == n) {
            uf.union((n - 1) * n + (col - 1), virtualBottom);
        }

        if (isUpOpen(row, col)) {
            uf.union(pos, xy2id(row - 1, col));
            fu.union(pos, xy2id(row - 1, col));
        }
        if (isDownOpen(row, col)) {
            uf.union(pos, xy2id(row + 1, col));
            fu.union(pos, xy2id(row + 1, col));
        }
        if (isLeftOpen(row, col)) {
            uf.union(pos, xy2id(row, col - 1));
            fu.union(pos, xy2id(row, col - 1));
        }
        if (isRightOpen(row, col)) {
            uf.union(pos, xy2id(row, col + 1));
            fu.union(pos, xy2id(row, col + 1));
        }
    }

    private int xy2id(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private boolean isUpOpen(int row, int col) {
        if (row == 1) return false;
        return grid[(row - 2) * n + (col - 1)];
    }

    private boolean isDownOpen(int row, int col) {
        if (row == n) return false;
        return grid[(row * n) + (col - 1)];
    }

    private boolean isLeftOpen(int row, int col) {
        if (col == 1) return false;
        return grid[(row - 1) * n + (col - 2)];
    }

    private boolean isRightOpen(int row, int col) {
        if (col == n) return false;
        return grid[(row - 1) * n + col];
    }

    private void checkParam(int row, int col) {
        if (row <= 0 || row > n) {
            throw new IllegalArgumentException();
        }
        if (col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
