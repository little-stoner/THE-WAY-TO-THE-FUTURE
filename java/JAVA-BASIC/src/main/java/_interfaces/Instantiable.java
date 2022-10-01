package _interfaces;


abstract class Uninstantiable {
    abstract void f();
    abstract void g();
}

public class Instantiable extends Uninstantiable {

    @Override
    void f() {

    }

    @Override
    void g() {

    }
}
