package _onjava8._files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ListOfLines {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(
                Paths.get("../streams/Cheese.dat")
        ).stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}
