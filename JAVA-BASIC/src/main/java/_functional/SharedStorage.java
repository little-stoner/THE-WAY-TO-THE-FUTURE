package _functional;

import _functional.Closure1;

import java.util.function.IntSupplier;

public class SharedStorage {
    public static void main(String[] args) {
        Closure1 closure1 = new Closure1();

        IntSupplier f1 = closure1.makeFunc(0);
        IntSupplier f2 = closure1.makeFunc(0);
        IntSupplier f3 = closure1.makeFunc(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());

    }
}
