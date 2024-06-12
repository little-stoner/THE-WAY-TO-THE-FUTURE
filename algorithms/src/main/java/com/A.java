package com;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class A {
    
    public static void main(String[] args) {
//        long millis = System.currentTimeMillis();
//        System.out.println(millis);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        now = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
//
//        System.out.println(now);
        List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        arr.forEach(a -> {
            if (a == 3) {
                throw new NullPointerException();
            }
        });
    }

}

