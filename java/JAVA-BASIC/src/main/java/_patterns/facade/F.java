package _patterns.facade;

public class F {

    private static class A {
        A(int x) {}
    }
    private static class B {
        B(long x) {}
    }
    private static class C {
        C(double x) {}
    }

    static A makeA(int x) { return new A(x); }
    static B makeB(long x) { return new B(x); }
    static C makeC(double x) { return new C(x); }

    public static void main(String[] args) {
        A a = F.makeA(1);
        B b = F.makeB(1);
        C c = F.makeC(1.0);
    }

}
