package _efectivejava.generics;

public class _16_Overriding {

    static class WordBox<S extends CharSequence> extends _8_Wildcard.Box<String> {
        public WordBox(S t) { super(t.toString().toLowerCase()); }
        public void reset(S t) {
            super.reset(t.toString().toLowerCase());
        }
    }
    public static void main(String[] args) {
        WordBox<String> city = new WordBox<String>("Skogland");
        // city.reset("Stavanger"); // error: ambiguous
    }


}
