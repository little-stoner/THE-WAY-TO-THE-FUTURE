package _efectivejava.item61;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {

        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        Comparator<Integer> naturalOrder0 = (i, j) -> {
            int ip = i, jp = j;
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        var r = List.of(1, 23, 12, 9, 3).stream().sorted(naturalOrder).collect(Collectors.toList());
        System.out.println(r);

        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));

    }

}
