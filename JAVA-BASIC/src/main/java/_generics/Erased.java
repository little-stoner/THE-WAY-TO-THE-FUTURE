package _generics;

public class Erased<T> {

    private final int SIZE = 100;

    public void f(Object arg) {

        // error
        // if (arg instanceof T) {}

        //
        // T var = new T();

        //
        // T[] array = new T[SIZE];

        //
        T[] array0 = (T[])new Object[SIZE];

    }

}
