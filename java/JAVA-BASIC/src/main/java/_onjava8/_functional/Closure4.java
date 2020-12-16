package _onjava8._functional;

import java.util.function.IntSupplier;

public class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}
