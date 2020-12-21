package _onjava8._files;

import _onjava.RmDir;

import java.io.File;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");
    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }
    static void refreshTestDir() throws Exception {
        if (Files.exists(test))
            RmDir.rmdir(test);
        if (!Files.exists(test))
            Files.createDirectories(test);
    }

    static void populateTestDir() throws Exception {
        for(int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if(!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("Directories.java"),
                        variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws Exception {

    }

}
