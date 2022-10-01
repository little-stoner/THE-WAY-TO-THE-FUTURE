package _typeinfo;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        System.out.println(intClass);
        System.out.println(genericIntClass);
        System.out.println(intClass == genericIntClass);
        intClass = double.class;
        // genericIntClass = double.class; // Illegal
    }
}
