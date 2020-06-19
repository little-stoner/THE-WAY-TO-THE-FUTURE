package _concurrent;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.io.*;
import java.nio.file.*;
import _onjava.*;


public class ParallelStreamPuzzle2 {

    public static final Deque<String> trace = new ConcurrentLinkedDeque<>();

    static class
    IntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger();
        public Integer get() {
            trace.add(current.get() + " : " + Thread.currentThread().getName());
            return current.getAndIncrement();
        }
    }
    
    public static void main(String[] args) throws IOException {

        List<Integer> x = Stream.generate(new IntGenerator())
            .limit(5)
            .parallel()
            .collect(Collectors.toList());
        System.out.println(x);
        //Files.write(Paths.get("E:\\VI\\JAVA-BASIC\\src\\main\\java\\_concurrent\\PSP2.txt"), trace);
        for(String s : trace) {
            System.out.println(s);
        }
    }

}
