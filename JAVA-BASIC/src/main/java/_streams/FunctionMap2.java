package _streams;

import java.util.stream.Stream;

class Numbered {
    final int n;
    Numbered(int n) { this.n = n; }

    @Override
    public String toString() {
        return "Numbered(" + n + ")";
    }
}

public class FunctionMap2 {

    public static void main(String[] args) {
        Stream.of(1, 5, 4, 9, 3)
                .map(Numbered::new)
                .forEach(System.out::println);
    }

}
