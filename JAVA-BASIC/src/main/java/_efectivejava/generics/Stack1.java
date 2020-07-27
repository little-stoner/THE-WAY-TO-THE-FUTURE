package _efectivejava.generics;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack1<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // the runtime type of the array won't be E[]
    // it will always be Object[]
    public Stack1() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
        // elements = new E[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public E pop() {
        if (size == 0) throw new EmptyStackException();
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
