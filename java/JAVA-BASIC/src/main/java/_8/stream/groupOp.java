package _8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class groupOp {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType =
                Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream().collect(
                Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }
                )
        );
        System.out.println(dishesByCaloricLevel);

        filterBefore();
        groupFilter();
        mapGroup();
        multiGroup();

    }

    public static void mapGroup() {
        Map<Dish.Type, List<String>> dishNamesByType =
                Dish.menu.stream()
                        .collect(Collectors.groupingBy(Dish::getType,
                                Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(dishNamesByType);
    }

    public static void groupFilter() {
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                Dish.menu.stream()
                        .collect(Collectors.groupingBy(Dish::getType,
                                Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
        System.out.println(caloricDishesByType);
    }

    public static void filterBefore() {
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                Dish.menu.stream().filter(dish -> dish.getCalories() > 500)
                        .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(caloricDishesByType);

    }

    public static void multiGroup() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                Dish.menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                }))
                );
        System.out.println(dishesByTypeCaloricLevel);
        Map<Dish.Type, Long> typesCount =
                Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                Dish.menu.stream()
                        .collect(Collectors.groupingBy(Dish::getType,
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        Map<Dish.Type, Dish> mostCaloricByType0 =
                Dish.menu.stream()
                        .collect(Collectors.groupingBy(Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get)
                        ));
        System.out.println(mostCaloricByType0);

        Map<Dish.Type, Integer> totalCaloriesByType =
                Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                Dish.menu.stream().collect(
                        Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                },
                                Collectors.toSet())));
        System.out.println(caloricLevelsByType);

    }

}
