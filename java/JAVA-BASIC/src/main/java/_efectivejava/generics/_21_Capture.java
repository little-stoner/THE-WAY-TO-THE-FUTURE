package _efectivejava.generics;

public class _21_Capture {


    public static void main(String[] args) {
        Number n = new Integer(3);
        // Class<Number> c = n.getClass();
        Class<?> c1 = n.getClass();
        Class<? extends Number> c2 = n.getClass();

        String s = new String("abc");
        // Class<String> cc = s.getClass();
        Class<?> cc = s.getClass();
        Class<? extends String> ccc = s.getClass();
    }

}
