package _functional;

import java.util.function.Function;

public class FunctionComposition {

    static Function<String, String>
    f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    },
    f2 = s -> s.substring(3),
    f3 = String::toLowerCase,
    f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f1.apply("AQA"));
        System.out.println(f2.apply("ABCDEFG"));
        System.out.println(f3.apply("AAAAAAAAA"));
        System.out.println(f4.apply("QQQQQQQQQQQQAQQQQQQQQQQQQQ"));
    }

}
