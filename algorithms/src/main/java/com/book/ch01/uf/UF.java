package com.book.ch01.uf;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class UF {

    private int[] id;
    private int[] sz;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i=0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() { return count; }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    ///////////////////////////////////////////////////////////////
    public int quickFind(int p) {
        return id[p];
    }
    public void quickFindUnion(int p, int q) {
        int pId = quickFind(p);
        int qId = quickFind(q);
        if (pId == qId) {
            return;
        }
        for (int i=0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    /////////////////////////////////////////////////////////////
    public int quickUnionFind(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void quickUnion(int p, int q) {
        // 6 components !
        // >>>>>>>>> 4154.968
        p = find(p);
        q = find(q);
        if (p == q) {
            return;
        }
        id[p] = q;
        count--;
    }

    /////////////////////////////////////////////////////////////
    public int weightedFind(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void weightedUnion(int p, int q) {
        // 6 components !
        // >>>>>>>>> 4.338
        int pid = find(p);
        int qid = find(q);
        int pw = sz[pid];
        int qw = sz[qid];
        if (pid == qid) {
            return;
        }
        if (pw > qw) {
            id[qid] = pid;
            sz[pid] = pw + qw;
        } else {
            id[pid] = qid;
            sz[qid] = pw + qw;
        }
        count--;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // int N = StdIn.readInt();
        String file = "/Users/viber/Mamba/algs4-data/tinyUF.txt";
        String mfile = "/Users/viber/Mamba/algs4-data/mediumUF.txt";
        String lfile = "/Users/viber/Mamba/algs4-data/largeUF.txt";
        Scanner scanner = new Scanner(new File(lfile));

        Stopwatch stopwatch = new Stopwatch();
        int N = scanner.nextInt();
        UF uf = new UF(N);

        // StdOut.println(Arrays.toString(uf.id));

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.weightedUnion(p, q);
            StdOut.println(p + " " + q);
            // StdOut.println(Arrays.toString(uf.id));
        }

        StdOut.println(uf.count() + " components ! ");
        System.out.println(" >>>>>>>>> " + stopwatch.elapsedTime());
    }

}
