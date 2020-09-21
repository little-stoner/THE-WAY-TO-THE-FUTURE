
/**
 * Java Will Init primitive field.
 * plus:
 * but java will not init primitives
 * of local variables.
 */

public class EX1 {

    int m;
    char n;

    public void kobe() {
        // int x;
        // compile error
        // local variable must be initailized before use
        int x = 9527;
        System.out.println(" local x: " + x);
    }

    public static void main(String[] args) {
        EX1 ex1 = new EX1();
        System.out.println(" m: " + ex1.m);
        System.out.println(" n: " + ex1.n);
        ex1.n = 'a';
        System.out.println(" n: " + ex1.n);
        ex1.kobe();
    }


}
