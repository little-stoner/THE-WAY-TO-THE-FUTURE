package _efectivejava.chapter10.item69;

public class HorribleException {
    public static void main(String[] args) {
        try {
            int i = 0;
            while (true) {
                String a = args[i + 1000];
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
