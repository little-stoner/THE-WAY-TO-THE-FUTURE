package _concurrent;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;

import _onjava.Rand;
import _onjava.Timer;


public class CollectionIntoStream {


    public static void main(String[] args) throws IOException {

        List<String> strings = Stream.generate(new Rand.String(6)).limit(10).collect(Collectors.toList());

        strings.forEach(System.out::println);

        String result = strings.stream().map(String::toUpperCase)
                .map(s -> s.substring(2))
                .reduce(":", (s1, s2) -> s1 + s2);
        System.out.println(result);


    }


}
