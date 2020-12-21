package _onjava8._files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();
    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("( " + id + " )r " + base.relativize(result));
        }
        else
            System.out.println("( " + id + ") " + result);
        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        Path p = Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_files/AddAndSubtractPaths.java");
        show(1, p);
        Path convoluted = p.getParent().getParent()
                .resolve("strings")
                .resolve("..")
                .resolve(p.getParent().getFileName());
        show(2, convoluted);
        show(3, convoluted.normalize());
    }
}
