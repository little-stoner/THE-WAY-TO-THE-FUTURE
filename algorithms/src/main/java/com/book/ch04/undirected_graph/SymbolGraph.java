package com.book.ch04.undirected_graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SymbolGraph {

    private ST<String, Integer> st;
    private String[] keys;
    private Graph G;
    public SymbolGraph(String filename, String delim) {
        st = new ST<>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        G = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String key) {
        return st.contains(key);
    }

    public int index(String key) {
        return st.get(key);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delim);
        Graph G = sg.G();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : G.adj(sg.index(source))) {
                StdOut.println("   " + sg.name(w));
            }
        }
    }

    public static class TestSearch {

        public static void main(String[] args) {
            Graph G = new Graph(new In(args[0]));
            int s = Integer.parseInt(args[1]);
            Search search = new Search(G, s);

            for (int v = 0; v < G.V(); v++) {
                if (search.marked(v)) {
                    StdOut.print(v + " ");
                }
            }
            StdOut.println();

            if (search.count() != G.V()) {
                StdOut.print(" NOT ");
            }
            StdOut.println(" connected ");

        }

    }
}
