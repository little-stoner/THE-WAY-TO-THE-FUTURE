package _onjava8._exceptions;

public class FinallyDemo0 {

    public static int m0() {
        try {
            return 0;
        } catch (Exception e) {

        } finally {
            return 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(m0());
    }
}
