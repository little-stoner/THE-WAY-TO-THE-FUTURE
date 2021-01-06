package _lowlevel;

import java.util.concurrent.atomic.AtomicInteger;

public class ReOrdering implements Runnable {

    int one, two, three, four, five, six;
    volatile int volaTile;
    AtomicInteger integer;

    @Override
    public void run() {
        one = 1;
        two = 2;
        three = 3;
        volaTile = 92;
        int x = four;
        int y = five;
        int z = six;
    }

}
