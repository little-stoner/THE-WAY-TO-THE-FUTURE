package _onjava8._files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_files/PartsOfPaths.java")
                .toAbsolutePath();
        for (int i=0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        System.out.println(p.getNameCount());
        System.out.println("===================");
        System.out.println(" ends with '.java': " + p.endsWith(".java"));
        for (Path pp : p) {
            System.out.print(pp + " : ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println(" Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
