package _generics.faq;

public class StaticMember<T> {

    private static int count = 0;
    public StaticMember() {
        count++;
    }
    private T instance;
    public T get() {
        return instance;
    }

    public static void main(String[] args) {
        StaticMember<Integer> s = new StaticMember<>();
        System.out.println(StaticMember.count);
        StaticMember<String> ss = new StaticMember<>();
        System.out.println(StaticMember.count);

    }

}
