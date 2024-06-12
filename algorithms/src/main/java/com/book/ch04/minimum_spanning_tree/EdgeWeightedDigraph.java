package com.book.ch04.minimum_spanning_tree;

import com.book.ch04.shortest_paths.DirectedEdge;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class EdgeWeightedDigraph {

    public final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }
    public EdgeWeightedDigraph(int V, int E) {
        this.V = V;
        this.E = E;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(In in) throws FileNotFoundException {
        this.V = 0;
    }
    public EdgeWeightedDigraph(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        this.V = scanner.nextInt();
        this.E = scanner.nextInt();
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
        while (scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            double weight = scanner.nextDouble();
            DirectedEdge edge = new DirectedEdge(from, to ,weight);
            adj[from].add(edge);
        }

        for (int v = 0; v < V; v++) {
            System.out.print(" # v: " + v);
            Bag<DirectedEdge> bag = adj[v];
            for (DirectedEdge edge : bag) {
                System.out.printf(" [%s->%s %f] ", edge.from(), edge.to(), edge.weight());
            }
            System.out.println("\n==============================================================");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new EdgeWeightedDigraph("/Users/viber/Mamba/algs4-data/tinyEWD.txt");
    }
    public int V() {return V;}
    public int E() { return E; }
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }

    @Override
    public String toString() {
        return "EdgeWeightedDigraph{" +
                "V=" + V +
                ", E=" + E +
                ", adj=" + Arrays.toString(adj) +
                '}';
    }
}
