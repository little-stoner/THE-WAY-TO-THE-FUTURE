package _8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ps {

    public static void ps() {
        List.of(1, 2, 3, 4, 5).parallelStream().collect(Collectors.toSet());
    }

    public static void main(String[] args) {
    }

}
