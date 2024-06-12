
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationX {
    private boolean[][] grid;
    private boolean[] full;
    private int n;
    private int openSites;
    private boolean percolated;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public PercolationX(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.grid = new boolean[n][n];
        this.full = new boolean[n * n];
        uf = new WeightedQuickUnionUF(n * n);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolated;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkParam(row, col);
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        checkParam(row, col);
        if (!isOpen(row, col)) {
            return false;
        }
        int pos = (row - 1) * n + (col - 1);
        return full[pos];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkParam(row, col);
        if (isOpen(row, col)) {
            return;
        }
        grid[row - 1][col - 1] = true;
        if (row == 1) {
            full[col - 1] = true;
        }
        openSites++;
        percolate(row, col);
    }

    private void percolate(int row, int col) {
        int pos = (row - 1) * n + (col - 1);
        if (isUpOpen(row, col)) {
            int up = (row - 2) * n + (col - 1);
            int root = uf.find(up);
            if (full[pos] && !full[root]) {
                full[root] = true;
            }
            if (!full[pos] && full[root]) {
                full[pos] = true;
            }
            uf.union(pos, up);
        }
        if (isDownOpen(row, col)) {
            int down = (row) * n + (col - 1);
            uf.union(pos, down);
        }
        if (isLeftOpen(row, col)) {
            uf.union(pos, pos - 1);
        }
        if (isRightOpen(row, col)) {
            uf.union(pos, pos + 1);
        }

        int x = uf.find(pos);
        if (full[pos] && !full[x]) {
            full[x] = true;
        }


        for (int i = 1; i <= n; i++) {
            if (!isOpen(n, i)) {
                continue;
            }
            int q = uf.find((n - 1) * n + (i - 1));
            if (full[q]) {
                percolated = true;
            }
        }

    }

    private boolean isUpOpen(int row, int col) {
        if (row == 1) return false;
        return grid[row - 2][col - 1];
    }

    private boolean isDownOpen(int row, int col) {
        if (row == n) return false;
        return grid[row][col - 1];
    }

    private boolean isLeftOpen(int row, int col) {
        if (col == 1) return false;
        return grid[row - 1][col - 2];
    }

    private boolean isRightOpen(int row, int col) {
        if (col == n) return false;
        return grid[row - 1][col];
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
        System.out.println(">>>>>>>>>>>");
    }
}
