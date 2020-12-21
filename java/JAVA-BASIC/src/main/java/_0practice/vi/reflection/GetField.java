package _0practice.vi.reflection;

import java.lang.reflect.Field;

class Foobar {
    private final String name;
    public Foobar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class GetField {
    public static void main(String[] args) {
        try {
            Foobar foobar = new Foobar("Peter");
            System.out.println("Name: " + foobar.getName());
            Class<?> clazz = Foobar.class;
            System.out.println(" Class: " + clazz);
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            String value = (String) field.get(foobar);
            System.out.println(" value : " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
