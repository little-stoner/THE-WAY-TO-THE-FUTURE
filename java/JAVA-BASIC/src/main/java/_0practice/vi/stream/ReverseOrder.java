package _0practice.vi.stream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseOrder {
    public static void main(String[] args) {
        reverse0();
        System.out.println(" =================== ");
        reverse1();
        System.out.println(" ===================== ");
        reverse2();
    }

    public static void reverse0() {
        Stream<Integer> r = Stream.of(2, 3, 4, 5)
                .sorted((f1, f2) -> Long.compare(f2, f1));
        System.out.println(r.collect(Collectors.toList()));
    }

    public static void reverse1() {
        Stream<Integer> r = Stream.of(2, 3, 4, 5)
                .sorted((f1, f2) -> Long.compare(f2, f1));
        System.out.println(r.sorted(Comparator.reverseOrder())
        .collect(Collectors.toList()));
    }

    public static void reverse2() {
        Stream<Integer> r = Stream.of(2, 3, 4, 5)
                .sorted((f1, f2) -> Long.compare(f2, f1));
        System.out.println(
                r.sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList())
        );
    }

}
