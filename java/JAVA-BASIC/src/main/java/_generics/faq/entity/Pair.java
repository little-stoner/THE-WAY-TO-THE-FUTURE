package _generics.faq.entity;

/**
 * @author viber
 */
public class Pair<X, Y> {
    private X first;
    private Y second;
    public Pair() {}
    public Pair(X a1, Y a2) {
        first = a1;
        second = a2;
    }

    public X getFirst() {
        return first;
    }

    public void setFirst(X first) {
        this.first = first;
    }

    public Y getSecond() {
        return second;
    }

    public void setSecond(Y second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("a", 1);
        Pair<?, ?> p = new Pair<>(1, 1);
    }
}
