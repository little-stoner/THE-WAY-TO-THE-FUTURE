package com.book.ch05;

import java.util.Arrays;

public class KeyIndexCount {

    private static class Rank {
        public String name;
        public int rank;
        public Rank() {}
        public Rank(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "{" + name + ":" + rank + "}";
        }
    }

    public static void sort(Rank[] ranks) {

        System.out.println(">> ranks: " + Arrays.toString(ranks));

        int[] count = new int[256 + 1];
        int N = ranks.length;

        for (int i = 0; i < N; i++) {
            count[ranks[i].rank + 1]++;
        }

        for (int r = 0; r < 256; r++) {
            count[r+1] += count[r];
        }

        Rank[] aux = new Rank[N];
        for (int i = 0; i < N; i++) {
            aux[count[ranks[i].rank]++] = ranks[i];
        }

        System.out.println(">> aux: " + Arrays.toString(aux));

    }

    public static void main(String[] args) {
        Rank[] ransk = {
                new Rank("Anderson", 2),
                new Rank("Brown", 3),
                new Rank("Davis",3),
                new Rank("Garcia",4),
                new Rank("Harris",1),
                new Rank("Jackson",3),
                new Rank("Johnson",4),
                new Rank("Jones",3),
                new Rank("Martin",1),
                new Rank("Martinez",1),
                new Rank("Miller",2),
                new Rank("Moore",1),
                new Rank("Rohinson",2),
                new Rank("Smith",4),
                new Rank("Taylor",3),
                new Rank("Thomas",4),
                new Rank("Thompson",4),
                new Rank("White",2),
                new Rank("Williams",3),
                new Rank("Wilson",4),
        };
        sort(ransk);
    }

}
