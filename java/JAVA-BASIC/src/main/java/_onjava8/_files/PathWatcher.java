package _onjava8._files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class PathWatcher {
    static Path test = Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_files/test");
    static void delTxtFiles() {
        try {
            Files.walk(test).filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println(" deleteing " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor().schedule(PathWatcher::delTxtFiles, 250, TimeUnit.MICROSECONDS);
        WatchKey key = watcher.take();
        for (WatchEvent evt : key.pollEvents()) {
            System.out.println(" evt.context(): " + evt.context() + " \nevt.count(): " + evt.count() +
                    "\nevt.kind(): " + evt.kind());
            System.exit(0);
        }
    }
}
