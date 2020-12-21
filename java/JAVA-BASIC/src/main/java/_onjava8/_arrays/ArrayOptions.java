package _onjava8._arrays;

import static _onjava.ArrayShow.*;

public class ArrayOptions {

    public static void main(String[] args) {

        BerylliumSphere[] a;

        BerylliumSphere[] b = new BerylliumSphere[5];

        show("b", b);

        BerylliumSphere[] c = new BerylliumSphere[4];

        for (int i=0; i < c.length; i++) {
            if (c[i] == null)
                c[i] = new BerylliumSphere();
        }

        BerylliumSphere[] d = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere()
        };

        a = new BerylliumSphere[] {
                new BerylliumSphere(),
                new BerylliumSphere()
        };

        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);

        a = d;

        System.out.println("a.length = " + a.length);

        System.out.println("==========================");

        int[] e;
        int[] f = new int[5];
        show("f", f);
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i*i;
        }
        int[] h = { 11, 2 , 23 };


    }

}
