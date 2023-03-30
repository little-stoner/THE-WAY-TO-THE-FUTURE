package _8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filterOp {

    public static void filterDish() {
        List<Dish> vegetarianDishes =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());

        System.out.println(vegetarianDishes);
    }

    public static void filterDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {


    }

}
