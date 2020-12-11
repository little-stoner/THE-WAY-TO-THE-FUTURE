package _onjava8._typeinfo.pets;


class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

public class MultiUnbound {

    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This _this = new This();
        twoArgs.call2(_this, 11, 3.14);
        threeArgs.call3(_this, 11, 3.14, "Three");
        fourArgs.call4(_this, 11, 3.14, "Four", 'x');
    }

}
