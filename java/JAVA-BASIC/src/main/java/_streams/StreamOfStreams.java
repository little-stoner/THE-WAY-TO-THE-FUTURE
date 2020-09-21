package _streams;

import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("GONZO", "kermit", "beaker"))
                .peek((i) -> {
                    System.out.println("============== el: " + i);
                })
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }
}
