package _efectivejava.chapter2.item8;

/**
 * @author viber
 */
public class Adult {
    public static void main(String[] args) {
        try (Room r = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
