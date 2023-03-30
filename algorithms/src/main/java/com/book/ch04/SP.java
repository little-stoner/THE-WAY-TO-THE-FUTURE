package com.book.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class SP {

    public SP(EdgeWeightedDigraph G, int s) {

    }


    public boolean distTo(int v) {
        return false;
    }

    public boolean hasPathTo(int v) {
        return false;
    }

    Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        SP sp = new SP(G, s);
        for (int t = 0; t < G.V(); t++) {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f); ", sp.distTo(t));
            if (sp.hasPathTo(t)) {
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "  ");
                }
            }
            StdOut.println();
        }
    }

}
