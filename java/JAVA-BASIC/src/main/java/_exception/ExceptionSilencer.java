package _exception;

public class
ExceptionSilencer {

    public static int  f() {
        try {
            System.out.println("before return");
            return 1;
        } finally {
            System.out.println("finally return");
            return 2;
        }
    }

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
