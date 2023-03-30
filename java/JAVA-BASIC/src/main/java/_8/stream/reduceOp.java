package _8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class reduceOp {

    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
    public static void main(String[] args) {
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        int calories = Dish.menu.stream().map(Dish::getCalories)
                .reduce(0, Integer::sum);

        int calories0 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();

    }

}
