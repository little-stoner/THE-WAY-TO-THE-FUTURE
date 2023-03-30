package com.book.ch03;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {

        int minlen = 10;
        ST<String, Integer> st =  new ST<>();

        String[] strings = new In("/Users/viber/Mamba/algs4-data/words3.txt").readAllStrings();

        for (int i=0; i < strings.length; i++) {
            String word = strings[0];
            if (word.length() < minlen) continue;
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }            
        }    
        String max = "";
        st.put(max, 0);    
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }        
        }
        StdOut.println(max + " " + st.get(max));
    }



}
