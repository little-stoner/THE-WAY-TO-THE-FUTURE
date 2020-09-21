package _functional;


class X {
    String f() { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {

    public static void main(String[] args) {


        TransformX sp = X::f ;      // [1]
        X x = new X();
        System.out.println(sp.transform(x));  // [2]
        System.out.println(x.f());

    }
}
