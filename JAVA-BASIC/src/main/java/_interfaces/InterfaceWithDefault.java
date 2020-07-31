package _interfaces;

public interface InterfaceWithDefault {
    void firstM();
    void secondM();
    default void newMethod() {
        System.out.println("new METHOD");
    }
}
