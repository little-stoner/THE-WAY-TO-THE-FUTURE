package _fp;

public class TriFunctionTest {
    static int f(int i, long l, double d) { return 99; }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf
                = TriFunctionTest::f;
        tf = (i, l, d) -> 12;
        tf.apply(1, 2L, 3.9);
    }
}
