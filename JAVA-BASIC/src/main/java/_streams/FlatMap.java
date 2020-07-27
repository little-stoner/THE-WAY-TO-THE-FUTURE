package _streams;

import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(
                        i -> Stream.of("Gonzo", "Fozzie", "beaker")
                ).forEach(System.out::println);
    }
}
