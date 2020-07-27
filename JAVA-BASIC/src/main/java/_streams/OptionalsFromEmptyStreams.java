package _streams;

import java.util.stream.Stream;

public class OptionalsFromEmptyStreams {

    public static void main(String[] args) {
        System.out.println(
                Stream.<String>empty().findFirst()
        );
        System.out.println(
                Stream.<String>empty().findAny()
        );
        System.out.println(
                Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER)
        );
    }

}
