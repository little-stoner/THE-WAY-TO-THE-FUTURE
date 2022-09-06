package _fp;

import java.util.function.IntSupplier;

public class AnonymouseClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
