package _efectivejava.chapter2.item8;

/**
 * @author viber
 */
public class Teenager {
    public static void main(String[] args) throws InterruptedException {
        new Room(99);
        System.out.println("Peace out");
        while (true) {
            Thread.sleep(1000);
            Runtime.getRuntime().gc();
        }
    }
}
