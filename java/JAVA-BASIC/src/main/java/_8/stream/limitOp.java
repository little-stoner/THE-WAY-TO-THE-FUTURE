package _8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class limitOp {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(dishes);
    }

}
