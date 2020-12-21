package _onjava8._exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try (
                Stream<String> in = Files.lines(
                        Paths.get("StreamAreAutoCloseable.java")
                );
                PrintWriter outfile = new PrintWriter("Result.txt");
        ) {
            in.skip(5).limit(1).map(String::toLowerCase)
                    .forEachOrdered(outfile::println);
        }
    }
}
