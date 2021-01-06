package _0practice.vi.thread;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        System.out.println(" >>>>>>>> run <<<<<<<<< ");
        int count = 0;
        while (count < 10) {
            System.out.println(" >>>>>>>>>> " + count++);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" ========================================================== ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new SimpleThread();
        System.out.println(t);
        System.out.println(t.getState());
        System.out.println(" ======================================================== ");
        t.start();
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        System.out.println("..........................................");
        TimeUnit.SECONDS.sleep(11);
        System.out.println(t.isAlive());
    }


}
