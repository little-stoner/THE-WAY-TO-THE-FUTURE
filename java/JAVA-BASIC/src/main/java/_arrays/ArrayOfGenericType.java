package _arrays;

public class ArrayOfGenericType<T> {

    T[] array;

    public ArrayOfGenericType(int size) {
        // array = new T[size];
        array = (T[]) new Object[size]; // unchecked cast
    }

    // public <U> U[] makeArray() { return new U[1]; }

}
