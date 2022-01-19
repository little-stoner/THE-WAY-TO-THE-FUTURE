package _concurrency.jcip;

import javax.annotation.concurrent.GuardedBy;

public class PrivateLock {
    private final Object mylock = new Object();
    @GuardedBy("mylock") Widget widget;
    void someMethod() {
        synchronized (mylock) {
            //
        }
    }
}
