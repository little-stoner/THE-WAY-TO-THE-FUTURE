package _onjava8._exceptions;

class ThreeException extends Exception {}

public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0)
                    throw new ThreeException();
                System.out.println(" NO excepiton ");
            } catch (ThreeException e) {
                System.out.println(" Three Exception ");
            } finally {
                System.out.println(" IN finally clause ");
                if (count == 2) break; // out of while
            }
        }
    }
}
