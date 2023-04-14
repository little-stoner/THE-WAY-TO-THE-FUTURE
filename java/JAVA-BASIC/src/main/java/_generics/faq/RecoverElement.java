package _generics.faq;

import java.util.ArrayList;
import java.util.List;

interface Contained {
}

interface Container<T extends Contained> {
    void add(T element);

    List<T> elements();

    Class<T> getElementType();
}

class MyContained implements Contained {
    private final String name;

    public MyContained(String name) {
        this.name = name;
    }

    public @Override String toString() {
        return name;
    }
}

class MyContainer implements Container<MyContained> {
    private final List<MyContained> _elements = new ArrayList<>();

    public void add(MyContained element) {
        _elements.add(element);
    }

    public List<MyContained> elements() {
        return _elements;
    }

    public Class<MyContained> getElementType() {
        return MyContained.class;
    }
}

class MetaContainer {
    private Container<? extends Contained> container;

    public void setContainer(Container<? extends Contained> container) {
        this.container = container;
    }

    // public void add(Contained element) {
    // container.add(element); // error
    // }

    public void add(Contained element) {
        _add(container, element);
    }

    private static <T extends Contained> void _add(Container<T> container, Contained element) {
        container.add(container.getElementType().cast(element));
    }

    public List<? extends Contained> elements() {
        return container.elements();
    }
}

public class RecoverElement {
}
