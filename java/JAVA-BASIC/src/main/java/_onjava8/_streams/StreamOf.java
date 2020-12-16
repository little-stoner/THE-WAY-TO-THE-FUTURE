package _onjava8._streams;

import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {
        Stream.of(
                new Bubble(1),
                new Bubble(2),
                new Bubble(3)
        ).forEach(System.out::println);

    }
}
