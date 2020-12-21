package _onjava8._files;

import com.alibaba.fastjson.support.hsf.HSFJSONUtils;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + " : " + p);
    }
    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("regularFile", Files.isRegularFile(p));
        show("Direcotry", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("************************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_files/PathInfo.java"));
        Path p = Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_files/PathInfo.java");
        Path ap = p.toAbsolutePath();

        URI u = p.toUri();
        System.out.println(" URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile(); // Don't be fooled
    }
}
