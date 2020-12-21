package _onjava8._validating;

import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkNotNull;

public class GuavaPreconditions {
    static void test(Consumer<String> c, String s) {
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println("Success");
        } catch (Exception e) {
            String type = e.getClass().getSimpleName();
            String msg = e.getMessage();
            System.out.println(type + (msg == null ? "" : ": " + msg));
        }
    }

    public static void main(String[] args) {
        test(s -> s = checkNotNull(s), "X");
    }
}
