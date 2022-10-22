package UnionFind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {


    private final boolean[][] isOpenSite;
    private final boolean[][] isFullSite;

    private final WeightedQuickUnionUF uf;
    private final int n;
    private int openSites = 0;
    private final byte[] rows = {-1, 0, 1, 0};
    private final byte[] cols = {0, -1, 0, 1};

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.n = n;
        this.isOpenSite = new boolean[n][n];
        this.isFullSite = new boolean[n][n];
        this.uf = new WeightedQuickUnionUF(n * n);
    }

    public void open(int row, int col) {
        validate(row, col);
        if (this.isOpenSite[row - 1][col - 1]) return;
        this.openSites++;
        this.isOpenSite[row - 1][col - 1] = true;
        if (row == 1) this.isFullSite[row - 1][col - 1] = true;
        connectWithNearSites(row, col, -1);
    }

    private void connectWithNearSites(int row, int col, int from) {
        boolean isFull = canBeFilled(row, col);
        if (isFull) {
            this.isFullSite[row - 1][col - 1] = true;
        }
        int numOfSite = this.n * (row - 1) + (col - 1);
        for (int i = 0; i < rows.length; i++) {
            if (from == this.n * (row - 1 - rows[i]) + (col - 1 - cols[i])) continue;
            unionNearest(row - rows[i], col - cols[i], numOfSite, isFull);
        }
    }

    private void unionNearest(int row, int col, int num, boolean isFull) {
        if (isInRangeAndOpen(row, col)) {
            if (isFull(row, col)) return;
            if (isFull) {
                this.isFullSite[row - 1][col - 1] = true;
                connectWithNearSites(row, col, num);
            }
            if (!(uf.find(this.n * (row - 1) + col - 1) == uf.find(num))) {
                uf.union(this.n * (row - 1) + col - 1, num);
                connectWithNearSites(row, col, num);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return this.isOpenSite[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return this.isFullSite[row - 1][col - 1];
    }

    public int numberOfOpenSites() {
        return this.openSites;
    }

    public boolean percolates() {
        for (int i = 0; i < this.n; i++) {
            if (isFullSite[this.n - 1][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean canBeFilled(int row, int col) {
        boolean isFull = this.isFullSite[row - 1][col - 1];
        for (int i = 0; i < rows.length; i++) {
            if (isFull) break;
            if (isInRangeAndOpen(row - rows[i], col - cols[i])) {
                isFull = this.isFullSite[row - 1 - rows[i]][col - 1 - cols[i]];
            }
        }
        return isFull;
    }

    private void validate(int row, int col) {
        if (isInRange(row, col)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isInRangeAndOpen(int row, int col) {
        return isInRange(row, col) && this.isOpenSite[row - 1][col - 1];
    }

    private boolean isInRange(int row, int col) {
        return (row <= this.n && row > 0) && (col <= this.n && col > 0);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(8);
        p.open(1, 2);
        p.open(1, 8);
        p.open(2, 2);

        System.out.println(p.percolates());
    }

}
