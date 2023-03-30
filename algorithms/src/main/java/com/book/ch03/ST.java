package com.book.ch03;

import edu.princeton.cs.algs4.StdOut;

public class ST<Key extends Comparable<Key>, Value> {


    public ST() {}

    public void put(Key key, Value value) {

    }

    public Value get(Key key) {
        return null;        
    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    public Key floor(Key key) {
        return null;
    }

    public Key ceiling(Key key) {
        return null;
    }

    public int rank(Key key) {
        return 0;
    }

    public Key select(int k) {
        return null;
    }


    public void deleteMin() {
    
    }

    public void deleteMax() {

    }

    public int size(Key lo, Key hi) {
        return 0;
    }

    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    Iterable<Key> keys() {
        return keys(min(), max());
    }


    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        // String[] strings = new In("/Users/viber/Mamba/algs4-data/words3.txt").readAllStrings();
        String[] strings = { "S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E" };
        for (int i=0; i < strings.length; i++) {
            String key = strings[i];
            st.put(key, i);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }

   
}
