package com.book.ch04.undirected_graph;

public class GraphUtil {

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v=0; v < G.V(); v++) {
            int degree = degree(G, v);
            if (maxDegree < degree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

    public static int avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoop(Graph G) {
        int nums = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    nums++;
                }
            }
        }
        return nums/2;
    }

    public static String Graph2String(Graph G) {
        String s = G.V() + " vertices, " + G.E() + " edges\n";
        for (int v = 0; v < G.V(); v++) {
            s += v + ": ";
            for (int w : G.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

}
