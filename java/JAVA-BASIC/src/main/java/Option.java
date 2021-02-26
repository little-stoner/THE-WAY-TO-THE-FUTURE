import java.util.Optional;

public class Option {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("null");
        System.out.println(o.orElse("k"));
    }
}
