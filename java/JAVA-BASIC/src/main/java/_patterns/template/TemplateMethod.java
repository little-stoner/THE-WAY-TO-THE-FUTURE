package _patterns.template;

import java.util.stream.IntStream;

abstract class ApplicationFramework {
    ApplicationFramework() {
        templateMethod();
    }
    abstract void customize1();
    abstract void customize2();
    private void templateMethod() {
        IntStream.range(0, 5).forEach(
                n -> { customize1(); customize1(); }
        );
    }
}

class MyApp extends ApplicationFramework {
    @Override
    void customize1() {
        System.out.println(">>>>>>>>>>>");
    }

    @Override
    void customize2() {
        System.out.println("<<<<<<<<<<<<");
    }
}

public class TemplateMethod {

    public static void main(String[] args) {
        new MyApp();
    }

}
