package _onjava8._concurrent;

public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        printInterrupted(1);

        Object o = new Object();

        try {
            synchronized (o) {
                printInterrupted(2);
                System.out.printf("A time %d \n", System.currentTimeMillis());
                o.wait(100);
                System.out.printf("B time %d \n", System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            System.out.println(" INTERRUPTED...... ");
        }
        System.out.printf(" C time %d \n", System.currentTimeMillis());

        printInterrupted(3);

        Thread.currentThread().interrupt();

        printInterrupted(4);

        try {
            System.out.printf("D time %d\n", System.currentTimeMillis());
            Thread.sleep(100);
            System.out.printf("E time %d\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println(" WAS interrupted\n");
        }
        System.out.printf("F time %d\n", System.currentTimeMillis());

        printInterrupted(5);

    }


    static void printInterrupted(int n) {
        System.out.printf("(%d) Am I interrupted? %s \n", n, Thread.currentThread().isInterrupted() ? " YES " : " NO ");
    }


}
