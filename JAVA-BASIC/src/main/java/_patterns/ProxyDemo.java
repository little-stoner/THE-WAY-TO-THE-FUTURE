package _patterns;

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
        implementation.f();
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
        p.g();
        p.h();
    }
}
