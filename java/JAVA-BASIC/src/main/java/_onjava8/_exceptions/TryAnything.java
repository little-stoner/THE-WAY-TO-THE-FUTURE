package _onjava8._exceptions;

import org.checkerframework.checker.units.qual.A;

class Anything implements AutoCloseable {
    @Override
    public void close() throws Exception {

    }
}

public class TryAnything {
    public static void main(String[] args) throws Exception {
        try (
                Anything a = new Anything();
        ) {
        }
    }
}
