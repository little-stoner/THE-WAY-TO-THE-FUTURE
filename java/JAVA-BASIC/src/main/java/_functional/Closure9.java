package _functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
//        ai = new ArrayList<>();
        return () -> ai;
    }
}
