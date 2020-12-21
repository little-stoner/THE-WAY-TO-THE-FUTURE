package _onjava8._exceptions;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputFileZ {

    private String fname;
    public InputFileZ(String fname) {
        this.fname = fname;
    }
    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }

    public static void main(String[] args) throws IOException {
        new InputFileZ("InputFileZ.java").getLines()
                .skip(15)
                .limit(1)
                .forEach(System.out::println);
    }

}
