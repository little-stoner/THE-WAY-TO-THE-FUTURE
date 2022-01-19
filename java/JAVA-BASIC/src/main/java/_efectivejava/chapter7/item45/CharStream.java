package _efectivejava.chapter7.item45;

public class CharStream {
    public static void main(String[] args) {
        // Does not produce the expected result
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();

        // Fixes the problem
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}