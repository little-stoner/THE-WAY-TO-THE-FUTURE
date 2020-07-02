import java.util.*;

public class FinalKeyWord {


    public static void main(String[] args) {
        KBR kb = new KBR();
        System.out.println(" a[]: " + Arrays.toString(kb.a));
        System.out.println(" a[2]: " + kb.a[2]);
        // you cant modify the final variable;
        // You will get `Cannot assign a value to final variable 'b'`
        // kb.b = 2;
        // kb.c = new String("g");

        // you can't change a's reference
        // kb.a = new int[] { 2, 3, 4 };
        // you can change the a's internal value
        kb.a[1] = 9;
        System.out.println(" a[]: " + Arrays.toString(kb.a));
        kb.t();
        kb.t();
    }

}

class KBR {
    final int[] a = new int[]{1, 2, 3};
    final int b = 0;
    final String c = "gigi";
    private static int counter;
    final int f, h;
    final static int g;

    public KBR() {
        f = 1;
        System.out.println("initial f");
    }

    static {
        g = 2;
        System.out.println("initial g");
    }

    {
        h = 3;
        System.out.println("initial h");
    }

    public void t() {
        System.out.println(">>>> ");
        final int k;
        // int j = 1;
        // System.out.println(j);             
        // k = 2;
        counter++;
        k = counter;
        System.out.println(">>>> " + k);
    }

}
