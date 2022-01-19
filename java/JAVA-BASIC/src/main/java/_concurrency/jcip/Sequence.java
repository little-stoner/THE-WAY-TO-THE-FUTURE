package _concurrency.jcip;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Sequence {

    @GuardedBy("this") private int value;
    public synchronized int getNext() {
        return value++;
    }

}
