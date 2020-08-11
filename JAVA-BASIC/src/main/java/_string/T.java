package _string;

public class T {

    public static void t(StringBuilder a, StringBuilder b) {
        a.append(b);
        a.append(".");
        b = a;
        System.out.println(">>>>>>>>>> " + a.toString());
        System.out.println(">>>>>>>> " + b.toString());
    }

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("A");
        StringBuilder b = new StringBuilder("B");

        t(a, b);

        System.out.println("a : " + a.toString());
        System.out.println("b : " + b.toString());
    }

}
