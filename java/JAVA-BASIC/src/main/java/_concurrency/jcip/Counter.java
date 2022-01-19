package _concurrency.jcip;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Counter {

    @GuardedBy("this") private long value = 0L;

    private long a = 9;
    private Long aa = 9L;
    private float b = 9;
    private Float bb = 9F;
    private double c = 8;
    private Double cc = 8d;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return ++value;
    }

}
