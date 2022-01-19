package com.mutatio;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;


/**
 * @author viber
 */
public class QuickFindUF {

    private int[] dot;
    private int count;

    public QuickFindUF(int N) {
        dot = new int[N];
        count = N;
        for(int i = 0; i < N; i++) {
            dot[i]  = i;
        }
    }

    private boolean connected(int p, int q) {
        return this.dot[p] == this.dot[q];
    }

    private void union(int p, int q) {
        int P = root(p);
        int Q = root(q);
        if (P == Q) {
            return;
        }
        for (int i = 0; i < dot.length; i++) {
            if (dot[i] == P) {
                dot[i] = Q;
            }
        }
        count--;
    }

    private int root(int p) {
        int index = dot[p];
        return index == p ? index : root(index);
    }

    private void find(int p) {

    }

    private int count() {
        return count;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) { continue; }
            uf.union(p, q);
            StdOut.println(p + "  " + q);
        }
        StdOut.println(uf.count() +  " components ");
        System.out.println("consume time: " + stopwatch.elapsedTime());
    }

}
