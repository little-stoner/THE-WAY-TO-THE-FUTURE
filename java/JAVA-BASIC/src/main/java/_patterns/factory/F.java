package _patterns.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class F {

    private static class Shape {
        private static int counter = 0;
        private int id = counter++;

        @Override
        public String toString() {
            return getClass().getSimpleName() + "[" + id + "]";
        }

        public void draw() {
            System.out.println(this + " draw ");
        }

        public void erase() {
            System.out.println(this + " erase ");
        }
    }

    private static class Circle extends Shape {
    }

    private static class Square extends Shape {
    }

    private static class Triangle extends Shape {
    }

    private interface FactoryMethod {
        Shape create(String type);
    }


    public static void test(FactoryMethod factory) {
        Stream.of("Circle",
                        "Square",
                        "Triangle",
                        "Square",
                        "Circle",
                        "Circle",
                        "Triangle")
                .map(factory::create)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count(); // Terminal operation
    }

    private static class ShapeFactory1 implements FactoryMethod {
        @Override
        public Shape create(String type) {
            switch (type) {
                case "Circle":
                    return new Circle();
                case "Square":
                    return new Square();
                case "Triangle":
                    return new Triangle();
                default:
                    throw new RuntimeException();
            }
        }
    }

    private static class ShapeFactory2 implements FactoryMethod {
        Map<String, Constructor> factories = new HashMap<>();
        static Constructor load(String id) {
            try {
                return Class.forName("_patterns.factory."+id)
                        .getConstructor();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Shape create(String id) {
            try {
                return (Shape) factories.computeIfAbsent(id, ShapeFactory2::load)
                        .newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
