package _generics.faq;

public class ArrayExtends {
    static class P {}
    static class A extends P {}
    static class B extends P {}

    public static void main(String[] args) {
        P[] p = new A[2];
        p[0] = new A();
        p[1] = new P();
    }

}
