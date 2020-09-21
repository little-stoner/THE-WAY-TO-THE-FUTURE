package _interfaces;

abstract class Basic3 {
    int f() { return 111; }
}

public class AbstractWithoutAbstracts {
    Basic3 b3 = new Basic3() {
        @Override
        int f() {
            return super.f();
        }
    };
}
