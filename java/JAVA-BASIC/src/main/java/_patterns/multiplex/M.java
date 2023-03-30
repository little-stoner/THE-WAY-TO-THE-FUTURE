package _patterns.multiplex;

import _onjava.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class M {

    private enum Outcome {WIN, LOSE, DRAW}

    private interface Item {
        Outcome compete(Item it);

        Outcome eval(Paper p);

        Outcome eval(Scissors s);

        Outcome eval(Rock r);
    }

    private static class Paper implements Item {
        @Override
        public Outcome compete(Item it) {
            return it.eval(this);
        }

        public Outcome eval(Paper p) {
            return Outcome.DRAW;
        }

        @Override
        public Outcome eval(Scissors s) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Rock r) {
            return Outcome.LOSE;
        }

        @Override
        public String toString() {
            return "Paper";
        }
    }

    private static class Scissors implements Item {

        @Override
        public Outcome compete(Item it) {
            return it.eval(this);
        }

        @Override
        public Outcome eval(Paper p) {
            return Outcome.LOSE;
        }

        @Override
        public Outcome eval(Scissors s) {
            return Outcome.DRAW;
        }

        @Override
        public Outcome eval(Rock r) {
            return Outcome.WIN;
        }

        @Override
        public String toString() {
            return "Scissors";
        }
    }

    private static class Rock implements Item {

        @Override
        public Outcome compete(Item it) {
            return it.eval(this);
        }

        @Override
        public Outcome eval(Paper p) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Scissors s) {
            return Outcome.LOSE;
        }

        @Override
        public Outcome eval(Rock r) {
            return Outcome.DRAW;
        }

        @Override
        public String toString() {
            return "Rock";
        }
    }

    private static class ItemFactory {
        static List<Supplier<Item>> items =
                Arrays.asList(Scissors::new, Paper::new, Rock::new);
        static final int SZ = items.size();
        private static SplittableRandom rand =
                new SplittableRandom(47);

        public static Item newItem() {
            return items.get(rand.nextInt(SZ)).get();
        }

        public static Tuple2<Item, Item> newPair() {
            return new Tuple2<>(newItem(), newItem());
        }
    }

    private static class Complete {
        public static Outcome match(Tuple2<Item, Item> p) {
            System.out.print(p.a1 + " -> " + p.a2 + " : ");
            return p.a1.compete(p.a2);
        }
    }


    public static void main(String[] args) {
        Stream.generate(ItemFactory::newPair)
                .limit(20)
                .map(Complete::match)
                .forEach(System.out::println);
    }



}
