package _8.stream;

import java.util.Optional;

public class findOp {

    public static void findAny() {
        Optional<Dish> dish =
                    Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();


                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny()
                        .ifPresent(d -> System.out.println(d.getName()));
    }

    public static void main(String[] args) {
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        boolean isHealthy = Dish.menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        boolean isHealthy2 = Dish.menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);

    }

}
