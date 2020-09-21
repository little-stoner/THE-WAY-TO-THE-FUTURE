package _functional;

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class LambdaExpressions {

    static Body bod = h -> h + " No Parens!";
    static Body bod2 = (h) -> h + " More details";
    static Description desc = () -> "Short info";
    static Multi mult = (h, n) -> h + n;
    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {

    }

}
