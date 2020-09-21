package _functional;

public class TriFunctiontest {

    static int f(int i, long l, double d) { return 99; }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctiontest::f;
        tf = (i, l , d) -> 12;
    }
}
