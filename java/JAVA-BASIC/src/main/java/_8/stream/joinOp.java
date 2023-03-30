package _8.stream;

import java.util.stream.Collectors;

public class joinOp {

    public static void main(String[] args) {
        System.out.println(
                Dish.menu.stream().map(Dish::getName)
                        .collect(Collectors.joining(", "))
        );
    }

}
