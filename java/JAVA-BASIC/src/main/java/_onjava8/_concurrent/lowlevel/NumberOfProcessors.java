package _onjava8._concurrent.lowlevel;

public class NumberOfProcessors {
    public static void main(String[] args) {
        System.out.println(
                Runtime.getRuntime()
                .availableProcessors()
        );
    }
}
