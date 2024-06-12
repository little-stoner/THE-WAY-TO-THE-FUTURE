package com.book.ch04.shortest_paths;

import com.book.ch04.minimum_spanning_tree.EdgeWeightedDigraph;

public class DijkstraAllPairsSP {

    private DijkstraSP[] all;
    DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DijkstraSP(G, v);
        }
    }

    Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    double dist(int s, int t) {
        return all[s].distTo(t);
    }

}
