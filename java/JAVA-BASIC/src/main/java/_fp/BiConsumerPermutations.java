package _fp;

import java.util.function.BiConsumer;

public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bicid = (i, d) -> System.out.format(" %d, %f%n ", i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i) -> System.out.format(" %d, %f%n ", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) -> System.out.format(" %d, %d%n ", i, l);

    public static void main(String[] args) {
        bicid.accept(47, 11.34);
        bicdi.accept(22.34, 11);
        bicil.accept(1, 1L);
    }

}
