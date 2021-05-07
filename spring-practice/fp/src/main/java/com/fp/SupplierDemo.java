package com.fp;

import java.util.function.Supplier;

public class SupplierDemo {

    public static Supplier<String> supplier = () -> "KKK";

    public static void main(String[] args) {
        System.out.println(supplier.get());
    }

}
