package _efectivejava.generics;

public class _1_HowToDeclareGenericType {

    static class Pair<X, Y> {
        private X first;
        private Y second;

        public Pair() {}
        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
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
    }

    public static void printPair(Pair<String, Long> pair) {
        System.out.println("(" + pair.getFirst() + "," + pair.getSecond() + ")");
    }
    public static void printPair0(Pair<?, ?> pair) {
        System.out.println("(" + pair.getFirst() + "," + pair.getSecond() + ")");
    }

    public static void arr() {
        Pair<String, String> a;
        // a = new Pair<String, String>[10];
    }


    public static void main(String[] args) {
        Pair<String, Long> limit = new Pair<String, Long>("maximum", 1024L);
        Pair<?, ?> limit0 = new Pair<String, Long>("maximum", 1024L);
        printPair(limit);
        printPair0(limit0);
    }

}
