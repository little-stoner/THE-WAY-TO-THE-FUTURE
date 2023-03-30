package _patterns.visitor;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class V {

    private interface Visitor {
        void visit(Gladiolus g);

        void visit(Renuculus r);

        void visit(Chrysanthemum c);
    }

    private interface Flower {
        void accept(Visitor v);
    }

    private static class Gladiolus implements Flower {
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    private static class Renuculus implements Flower {
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    private static class Chrysanthemum implements Flower {
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    private static class StringVal implements Visitor {
        String s;

        @Override
        public String toString() {
            return s;
        }

        @Override
        public void visit(Gladiolus g) {
            s = "Gladiolus";
        }

        @Override
        public void visit(Renuculus r) {
            s = "Renuculus";
        }

        @Override
        public void visit(Chrysanthemum c) {
            s = "Chrysanthemum ";
        }
    }

    private static class Bee implements Visitor {
        @Override
        public void visit(Gladiolus g) {
            System.out.println("Bee and Gladiolus");
        }

        @Override
        public void visit(Renuculus r) {
            System.out.println("Bee and Renuculus");
        }

        @Override
        public void visit(Chrysanthemum c) {
            System.out.println("Bee and Chrysanthemum");
        }
    }

    private static class FlowerFactory {
        static List<Supplier<Flower>> flowers =
                Arrays.asList(Gladiolus::new, Renuculus::new, Chrysanthemum::new);
        static final int SZ = flowers.size();
        private static SplittableRandom rand =
                new SplittableRandom(47);

        public static Flower newFlower() {
            return flowers.get(rand.nextInt(SZ)).get();
        }
    }


    public static void main(String[] args) {
        List<Flower> flowers = Stream.generate(FlowerFactory::newFlower)
                .limit(10)
                .collect(Collectors.toList());
        StringVal sval = new StringVal();
        flowers.forEach(f -> {
            f.accept(sval);
            System.out.println(sval);
            // Perform "Bee” operation on all Flowers:
        });
        Bee bee = new Bee();
        flowers.forEach(f -> f.accept(bee));
    }
}
