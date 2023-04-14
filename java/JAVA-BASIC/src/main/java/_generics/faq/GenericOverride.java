package _generics.faq;

public class GenericOverride {

    private static class Box<T> {
        private T theThing;
        public Box(T t) {this.theThing = t;}
        public void reset(T t) { theThing = t;}
    }
    private static class WordBox<S extends CharSequence> extends Box<String> {
        public WordBox(S t) { super(t.toString().toLowerCase());}
        public void reset(S t) { super.reset(t.toString().toLowerCase());}
    }

    public static void main(String[] args) {
        WordBox<String> city = new WordBox<>("Skogland");
       // city.reset("Stavanger"); // error: ambiguous
    }
}
