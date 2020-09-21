package _streams;

import java.util.stream.Stream;

public class Fibonacci {
    int x = 1;
    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            System.out.println(">>>>>>>>>>>>>>>>>>>> i: " + i);
            System.out.println("#######################  x: " + x);
            int result = x + i;
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ result: " + result);
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(20)
                .limit(10)
                .forEach(System.out::println);
//        System.out.println(new Fibonacci().numbers());
    }
}
