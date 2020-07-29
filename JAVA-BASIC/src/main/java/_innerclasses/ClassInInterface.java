package _innerclasses;

public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("HOOOOOOOOOOOO");
        }
    }

    public static void main(String[] args) {
        new Test().howdy();
    }
}
