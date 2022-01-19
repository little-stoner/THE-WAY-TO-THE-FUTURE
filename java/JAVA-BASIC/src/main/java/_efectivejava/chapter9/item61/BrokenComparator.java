package _efectivejava.chapter9.item61;

import java.util.*;

// Broken comparator - can you spot the flaw? - Page 273
public class BrokenComparator {
    public static void main(String[] args) {
        Integer m = 0, n = 0;
        System.out.println(m == n);
        System.out.println(Integer.valueOf(1) == Integer.valueOf(1));
        System.out.println(new Integer(2) == new Integer(2));

//        Comparator<Integer> naturalOrder =
//                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // Fixed Comparator - Page 274
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // Auto-unboxing
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}