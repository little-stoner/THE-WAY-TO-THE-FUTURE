package _onjava8._files;

import java.nio.file.*;

public class Find {
    public static void main(String[] args) throws Exception {
        Path test = Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_files/test");
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createDirectory(test.resolve("dir.tmp"));

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{tmp,txt}");

        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);

        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println(" ****************** ");
        Files.walk(test).filter(Files::isRegularFile).map(Path::getFileName).filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
