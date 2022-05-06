package _proxy;

import net.sf.cglib.util.ParallelSorter;

public class ParallelSort {

    public static void main(String[] args) {
        Integer[][] value = {
                {4, 3, 9, 0},
                {2, 1, 6, 0}
        };
        ParallelSorter.create(value).mergeSort(0);
        for (Integer[] row : value) {
            int former = -1;
            for (int val : row) {
                System.out.println(val);
            }
        }
    }
}
