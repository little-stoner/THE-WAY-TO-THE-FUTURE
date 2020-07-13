package _generics;

public class ReturnGenericType < T extends HasF>  {
    private T obj;
    ReturnGenericType(T x) { obj = x; }
    private T get() { return obj; }
}
