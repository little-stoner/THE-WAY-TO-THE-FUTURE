package _generics.faq;


import _generics.faq.entity.Name;
import _generics.faq.entity.Pair;

public class GenericArray {

    void printArrayOfStringPairs(Pair<String, String>[] pa) {
        for (Pair<String, String> p : pa) {
            if (p != null) {
                System.out.println(p.getFirst()+ " " + p.getSecond());
            }
        }
    }

    Pair<String, String>[]  createArrayOfStringParis() {
        Pair<String, String>[] arr = new Name[2];
        arr[0] = new Name("A", "B");
        arr[1] = new Pair<String, String>("p", "q");
        return arr;
    }

    void extractStringPairsFromArray(Pair<String, String>[] arr) {
        Name name = (Name) arr[0];
        Pair<String, String> p1 = arr[1];
    }
    void test() {
        Pair<String, String>[] arr = createArrayOfStringParis();
        printArrayOfStringPairs(arr);
        extractStringPairsFromArray(arr);
    }

    public static void main(String[] args) {
        new GenericArray().test();
    }

}
