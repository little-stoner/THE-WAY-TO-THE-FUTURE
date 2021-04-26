package _concurrency;

import java.util.concurrent.TimeUnit;

public class VolatileDemo extends Thread {

    private
    // volatile
    int tValue;

    public VolatileDemo(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        for (int i=0; i < 3; i++) {
            System.out.println(getName() + " : " + i);
            if (getName().equalsIgnoreCase("Thread 1")) {
                tValue = 10;
            }
            if (getName().equalsIgnoreCase("Thread 2")) {
                System.out.println(" Test Value : " + tValue);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new VolatileDemo("Thread 1").start();
        new VolatileDemo("Thread 2").start();

        VolatileDemo v = new VolatileDemo("");
        v = null;

        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("  @@@ ");


    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(">>>>>>>>>>>>>>>>");
        throw new RuntimeException("@@@@@@@");
    }
}
