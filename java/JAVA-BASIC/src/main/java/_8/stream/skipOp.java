package _8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class skipOp {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(dishes);
    }

}
