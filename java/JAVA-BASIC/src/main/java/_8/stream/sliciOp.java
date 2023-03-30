package _8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class sliciOp {

    public static List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));


    public static void main(String[] args) {
        List<Dish> filteredMenu
                = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(filteredMenu);

        List<Dish> filteredMenu0
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(filteredMenu0);

        List<Dish> filteredMenu1
                = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(filteredMenu1);


    }

}
