package _efectivejava.chapter2;

/**
 * @author viber
 */

public class NutritionFactsTelescoping {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFactsTelescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }
    public NutritionFactsTelescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }
    public NutritionFactsTelescoping(int servingSize, int servings, int calories,
                                     int fat) {
        this(servingSize, servings, calories, fat, 0);
    }
    public NutritionFactsTelescoping(int servingSize, int servings, int calories,
                                     int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    public NutritionFactsTelescoping(int servingSize, int servings, int calories,
                                     int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsTelescoping cocaCola =
                new NutritionFactsTelescoping(240, 8, 100, 0, 35, 27);
    }

}
