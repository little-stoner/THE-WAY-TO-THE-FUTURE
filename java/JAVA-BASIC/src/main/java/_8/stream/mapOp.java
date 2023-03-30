package _8.stream;

import java.util.stream.Collectors;

public class mapOp {

    public static void main(String[] args) {
        System.out.println(
                Dish.menu.stream()
                        .map(Dish::getName)
                        .collect(Collectors.toSet())
        );
    }

}
