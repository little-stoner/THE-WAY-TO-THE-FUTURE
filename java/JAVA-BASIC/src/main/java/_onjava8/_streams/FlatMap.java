package _onjava8._streams;

import java.util.List;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3).flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);

        Stream.of(List.of(1,2,3), List.of(4,5,6))
                .flatMap(List::stream)
                .forEach(System.out::print);
        System.out.println();
    }
}
