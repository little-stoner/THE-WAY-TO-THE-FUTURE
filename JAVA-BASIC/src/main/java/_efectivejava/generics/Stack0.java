package _efectivejava.generics;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack0<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // the runtime type of the array won't be E[]
    // it will always be Object[]
    @SuppressWarnings("unchecked")
    public Stack0() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        // elements = new E[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public E pop() {
        if (size == 0) throw new EmptyStackException();
        E result = elements[--size];
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

    public static void main(String[] args) {
        Stack0<String> stack = new Stack0<>();
        for (String arg : args) {
            stack.push(arg);
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }

}
