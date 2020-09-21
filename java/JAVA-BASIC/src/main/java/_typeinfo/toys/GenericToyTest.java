package _typeinfo.toys;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {

        Class<FancyToy> ftClass = FancyToy.class;

        FancyToy fancyToy = ftClass.newInstance();

        Class<? super FancyToy> up = ftClass.getSuperclass();

//        Class<Toy> up2 = ftClass.getSuperclass();

        Object obj = up.newInstance();


    }
}
