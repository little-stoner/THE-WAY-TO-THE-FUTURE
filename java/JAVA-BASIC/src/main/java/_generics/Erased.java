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

    public void g(T i) {
        System.out.println(i);
        System.out.println(i.getClass());
    }

    public void h() {

        System.out.println();
        T t = (T) "AB";
        System.out.println(t.getClass());
    }

    public static void main(String[] args) {

        Erased<String> e = new Erased<>();
        e.h();



    }

}
