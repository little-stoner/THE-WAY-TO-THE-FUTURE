package _patterns.proxy;

interface ProxyBase {
    void f();
    void g();
    void h();
}

class Proxy implements ProxyBase {
    private ProxyBase implementation;
    Proxy() {
        implementation = new Implementation();
    }

    @Override
    public void f() {
        System.out.println(" before f(); ");
        implementation.f();
        System.out.println(" after f(); ");
    }

    @Override
    public void g() {
        implementation.g();
    }

    @Override
    public void h() {
        implementation.h();
    }
}

class Implementation implements ProxyBase {
    @Override
    public void f() {
        System.out.println(" Implementation f(); ");
    }

    @Override
    public void g() {

    }

    @Override
    public void h() {

    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Proxy p = new Proxy();
        p.f();
    }
}
