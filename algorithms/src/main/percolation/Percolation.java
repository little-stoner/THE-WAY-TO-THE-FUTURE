
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private boolean[] full;
    private int n;
    private int openSites;
    private boolean percolated;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.grid = new boolean[n * n];
        this.full = new boolean[n * n];
        uf = new WeightedQuickUnionUF(n * n);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkParam(row, col);
        if (isOpen(row, col)) {
            return;
        }
        int pos = (row - 1) * n + (col - 1);
        grid[pos] = true;
        if (row == 1) {
            full[pos] = true;
        }
        openSites++;
        percolate(row, col);
    }

    private void percolate(int row, int col) {
        row -= 1;
        col -= 1;
        int pos = row * n + col;
        // union up, down, left, right
        int up = (row - 1) * n + col;
        int down = (row + 1) * n + col;
        int left = pos - 1;
        int right = pos + 1;
        //
        if (isUpOpen(row, col)) {
            uf.union(pos, up);
        }
        if (isDownOpen(row, col)) {
            uf.union(pos, down);
        }
        if (isLeftOpen(row, col)) {
            uf.union(pos, left);
        }
        if (isRightOpen(row, col)) {
            uf.union(pos, right);
        }

        int x = uf.find(pos);

        for (int i = 0; i < n; i++) {
            if (!isOpen(1, i + 1)) {
                continue;
            }
            int p = uf.find(i);
            if (p == x) {
                full[x] = true;
            }
            for (int j = 0; j < n; j++) {
                if (!isOpen(n, j + 1)) {
                    continue;
                }
                int q = uf.find((n - 1) * n + j);
                if (p == q) {
                    percolated = true;
                }
            }
        }
    }
    private void checkPercolation() {
        for (int i = 1; i <= n; i++) {
            if (!grid[(n - 1) * n + (i - 1)]) {
                continue;
            }
            int root = uf.find((n - 1) * n + (i - 1));
            if (full[root]) {
                percolated = true;
            }
        }
    }

    private boolean isUpOpen(int row, int col) {
        if (row == 0) return false;
        return grid[(row - 1) * n + col];
    }

    private boolean isDownOpen(int row, int col) {
        if (row == n - 1) return false;
        return grid[(row + 1) * n + col];
    }

    private boolean isLeftOpen(int row, int col) {
        if (col == 0) return false;
        return grid[row * n + (col - 1)];
    }

    private boolean isRightOpen(int row, int col) {
        if (col == n - 1) return false;
        return grid[row * n + (col + 1)];
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkParam(row, col);
        int pos = (row - 1) * n + (col - 1);
        return grid[pos];
    }

    public boolean isFull(int row, int col) {
        checkParam(row, col);
        if (!isOpen(row, col)) {
            return false;
        }
        int pos = (row - 1) * n + (col - 1);
        int x = uf.find(pos);
        return full[x];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolated;
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
