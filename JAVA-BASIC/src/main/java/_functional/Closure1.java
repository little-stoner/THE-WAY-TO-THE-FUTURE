package _functional;

import java.util.function.IntSupplier;

public class Closure1
{

    int i;
    IntSupplier makeFunc(int x) {
        return () -> x + i++;
    }

}
