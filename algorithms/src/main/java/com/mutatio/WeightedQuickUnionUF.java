package com.mutatio;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author viber
 */
public class WeightedQuickUnionUF {

    private int[] dot;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        this.dot = new int[N];
        this.sz = new int[N];
        this.count = N;
        for(int i = 0; i < N; ++i) {
            this.dot[i] = i;
            this.sz[i] = 1;
        }
    }

    private boolean connected(int p, int q) {
        return this.dot[p] == this.dot[q];
    }

    private int count() {
        return count;
    }

    private void union(int p, int q) {
        int rootP = this.root(p);
        int rootQ = this.root(q);
        if (rootP == rootQ) {
            return;
        }
        if (sz[rootP] > sz[rootQ]) {
            dot[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        } else {
            dot[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        }
        count--;
    }

    private int root(int p) {
        int index = dot[p];
        return index == p ? index : this.root(index);
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) { continue; }
            uf.union(p, q);
            StdOut.println(p + "  " + q);
        }
        StdOut.println(uf.count() +  " components ");
        System.out.println("consume time: " + stopwatch.elapsedTime());
        // weighted quick union : 42.434
        // path compression:
    }

}
