package _8;

public interface I {

    default void a() {
        System.out.println("default");
    }

    static void b() {
        System.out.println("static");
    }

}
