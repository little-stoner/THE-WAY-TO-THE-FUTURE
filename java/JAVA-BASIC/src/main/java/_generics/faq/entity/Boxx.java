package _generics.faq.entity;

public class Boxx<T> {

    public T t;
    public Boxx(T t) {
        this.t = t;
    }
    public Boxx(Boxx<? extends T> box) {
        t = box.t;
    }

    public boolean equalTo(Boxx<T> other) {
        return this.t.equals(other.t);
    }

    public Boxx<T> copy() {
        return new Boxx<>(t);
    }




}
