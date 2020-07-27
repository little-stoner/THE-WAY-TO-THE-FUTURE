package _efectivejava.generics;

import java.util.*;

public class WildCard {

    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) result++;
        }
        return result;
    }

    static int numElementsInCommon0(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<?> c = new ArrayList<>();
        // c.add("hel");

    }

}
