package _onjava8._streams;

import java.util.Optional;

public class CreatingOptionals {

    static void test(String testName, Optional<String> opt) {
        System.out.println(" ======== " + testName + " ===== ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {

    }

}
