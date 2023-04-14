package _generics.faq;

import _generics.faq.entity.Pair;

public class Covariant {

    void generic() {
        Pair[] intsPair = new Pair[10];
        intsPair[0] = new Pair<Integer, Integer>(1, 2);
        Pair<String, String> p = intsPair[0];
        System.out.println(p.getFirst());
    }

    void array() {
        Integer[] ints = new Integer[5];
        String[] strs = new String[2];
        Object[] o = ints;
        strs = (String[]) o;
    }

    public static void main(String[] args) {
        new Covariant().generic();
    }
}
