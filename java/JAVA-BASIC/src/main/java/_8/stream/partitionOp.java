package _8.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class partitionOp {

    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu =
            Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);


        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType0 =
            Dish.menu.stream().collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType0);


        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                Dish. menu.stream().collect(
                        Collectors. partitioningBy(Dish::isVegetarian,
                                Collectors. collectingAndThen(Collectors. maxBy(Comparator. comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);




    }

}
