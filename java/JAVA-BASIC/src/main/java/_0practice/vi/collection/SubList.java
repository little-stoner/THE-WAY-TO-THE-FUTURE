package _0practice.vi.collection;

import java.util.Arrays;
import java.util.List;

public class SubList {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(a.subList(0, 0));
        System.out.println(a.subList(0, 2));

        a.subList(0, 5).set(2, 9);
        System.out.println(a);

    }

}
