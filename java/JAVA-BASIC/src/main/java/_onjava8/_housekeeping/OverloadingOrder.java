package _onjava8._housekeeping;

public class OverloadingOrder {

    static void f(String s, int i) {

    }

    static void f(int i, String s) {

    }

    public static void main(String[] args) {
        f( "S", 11);
        f( 22, "SS");
    }

}
