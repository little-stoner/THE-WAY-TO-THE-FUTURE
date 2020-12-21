package _0practice.vi.genrics;

public class MyType<E> {
    class Inner {}
    static class Nested {}

    public static void main(String[] args) {
        MyType mt;       // warning
        MyType.Inner in; // warning
        MyType<Integer>.Inner inn;

        MyType.Nested nest;
        MyType<Object> mt1;
        MyType<?> mt2;

    }
}
