package _patterns.command;

import java.util.Arrays;
import java.util.List;

public class C {

    private static class CommandPattern {
        List<Runnable> macro = Arrays.asList(
                () -> System.out.println("Hello "),
                () -> System.out.println("World! "),
                () -> System.out.println(" I'm the command pattern! ")
        );
    }

}
