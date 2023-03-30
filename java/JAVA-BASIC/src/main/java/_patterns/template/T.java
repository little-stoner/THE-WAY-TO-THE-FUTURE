package _patterns.template;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class T {
    private static class App {
        App(Consumer<Integer> c1, Consumer<Integer> c2) {
            templateMethod(c1, c2);
        }
        private void templateMethod(
                Consumer<Integer> c1,
                Consumer<Integer> c2
        ) {
            IntStream.range(0, 5).forEach(
                    n -> {
                        c1.accept(n);
                        c2.accept(n);
                    }
            );
        }
    }

    public static void main(String[] args) {
        new App(System.out::print,
                n -> System.out.print(n+1));
    }

}
