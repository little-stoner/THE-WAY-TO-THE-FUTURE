package com.book.ch04.directed_graph;


import com.book.ch04.undirected_graph.Graph;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;

public class Topological {

    private Iterable<Integer> order;
    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order == null;
    }

    public static void main(String[] args) {
//        String filename = args[0];
//        String separator = args[1];

        SymbolDigraph sg = new SymbolDigraph("/Users/viber/Mamba/algs4-data/jobs.txt", "/");
        Topological top = new Topological(sg.digraph());

        for (int v : top.order()) {
            StdOut.println(sg.nameOf(v));
        }
    }

}
