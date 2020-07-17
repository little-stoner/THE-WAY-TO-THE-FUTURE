package _functional;

import java.util.function.Function;

interface FuncSS extends Function<String, String> {}  // [1]

public class ProduceFunction {

    static FuncSS produce() {
        return String::toLowerCase;                   // [2]
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YEEEEEEEEEEEEEE"));
    }

}