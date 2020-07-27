package _functional;

import java.util.function.IntSupplier;

public class Closure3 {
    IntSupplier makeFun( int x) {
         int i = 0;
//        return () -> x++ + i++;
        return () -> x + i;
    }
}
