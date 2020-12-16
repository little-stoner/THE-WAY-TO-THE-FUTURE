package _onjava8._streams;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

public class Matching {

    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                        .boxed()
                        .peek(n -> System.out.format(" %d ", n)),
                        n -> n < val
                )
        );
    }
}
