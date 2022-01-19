package _efectivejava.generics;

import java.util.ArrayList;
import java.util.List;

public class _19_Recover {

    interface Contained {}
    interface Container<T extends Contained> {
        void add(T element);
        List<T> elements();
        Class<T> getElementType();
    }
    static class MyContained implements Contained {
        private final String name;
        public MyContained(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyContained{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class MyContainer implements Container<MyContained> {
        private final List<MyContained> _elements = new ArrayList<MyContained>();
        @Override
        public void add(MyContained element) {_elements.add(element);}
        @Override
        public List<MyContained> elements() {return _elements;}

        @Override
        public Class<MyContained> getElementType() {
            return MyContained.class;
        }
    }

    static class MetaContainer {
        private Container<? extends Contained> container;
        public void setContainer(Container<? extends Contained> container) {
            this.container = container;
        }
        public void add(Contained element) {
            _add(container, element);
        }
        private static <T extends Contained> void _add(Container<T> container, Contained element){
            container.add(container.getElementType().cast(element));
        }
        public List<? extends Contained> elements() {return container.elements();}
    }

    interface GenericType<T> {
        void method(T arg);
        Class<T> getTypeArgument();
    }
    static class ConcreteType implements GenericType<Integer> {
        @Override
        public void method(Integer arg) {}
        @Override
        public Class<Integer> getTypeArgument() {return Integer.class;}
    }

    static class GenericUsage {
        private GenericType<?> reference;
        public void method(Object arg) {
            _helper(reference, arg);
        }
        private static <T> void _helper(GenericType<T> reference, Object arg) {
            reference.method(reference.getTypeArgument().cast(arg));
        }
    }



}
