package _concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {


    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println(" tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(0, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttemptLocking at = new AttemptLocking();
        at.untimed();
        at.timed();

        //
        new Thread() {
            { setDaemon(true);}

            @Override
            public void run() {
                at.lock.lock();
                System.out.println(" acquired ");
            }
        }.start();
        //
        TimeUnit.SECONDS.sleep(1);
        System.out.println(" ========================= ");
        Thread.yield();
        at.untimed();

        Thread.currentThread().interrupt();
        at.timed();

    }

}
