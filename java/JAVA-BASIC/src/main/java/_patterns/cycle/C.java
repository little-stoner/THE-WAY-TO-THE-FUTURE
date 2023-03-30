package _patterns.cycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C {

    private static abstract class Trash {
        double weight;

        Trash(double wt) {
            weight = wt;
        }

        abstract double value();

        // Sums the value of Trash in a bin:
        private static double val;

        static void sumValue(List<? extends Trash> bin) {
            val = 0.0f;
            bin.forEach(t -> {
                val += t.weight * t.value();
                System.out.println(
                        "weight of " + t.getClass().getSimpleName()
                                + " = " + t.weight
                );
            });
            System.out.println("Total value = " + val);
        }
    }

    private static class Aluminum extends Trash {
        static double val = 1.67f;

        Aluminum(double wt) {
            super(wt);
        }

        @Override
        double value() {
            return val;
        }

        static void value(double newval) {
            val = newval;
        }
    }

    private static class Paper extends Trash {
        static double val = 0.10f;

        Paper(double wt) {
            super(wt);
        }

        @Override
        double value() {
            return val;
        }

        static void value(double newval) {
            val = newval;
        }
    }

    private static class Glass extends Trash {
        static double val = 0.23f;

        Glass(double wt) {
            super(wt);
        }

        @Override
        double value() {
            return val;
        }

        static void value(double newval) {
            val = newval;
        }
    }

    private static class TrashFactory {
        static List<Function<Double, Trash>> ttypes =
                Arrays.asList(
                        Aluminum::new, Paper::new, Glass::new);
        static final int SZ = ttypes.size();
        private static SplittableRandom rand =
                new SplittableRandom(47);

        public static Trash newTrash() {
            return ttypes.get(rand.nextInt(SZ))
                    .apply(rand.nextDouble());
        }

    }

    public static void main(String[] args) {
        List<Trash> bin = Stream.generate(TrashFactory::newTrash)
                .limit(25).collect(Collectors.toList());
        // Sort the Trash:
        // RTTI to discover Trash type:
        List<Glass> glassBin = new ArrayList<>();
        List<Paper> paperBin = new ArrayList<>();
        List<Aluminum> alBin = new ArrayList<>();
        bin.forEach(t -> {
            if (t instanceof Aluminum) alBin.add((Aluminum) t);
            if (t instanceof Paper) paperBin.add((Paper) t);
            if (t instanceof Glass) glassBin.add((Glass) t);
        });
        Trash.sumValue(alBin);
        Trash.sumValue(paperBin);
        Trash.sumValue(glassBin);
        Trash.sumValue(bin);
    }
}
