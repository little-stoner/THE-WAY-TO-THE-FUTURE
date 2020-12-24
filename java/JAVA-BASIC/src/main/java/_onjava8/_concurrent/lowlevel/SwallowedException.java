package _onjava8._concurrent.lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SwallowedException {

    public static void main(String[] args)
            throws Exception {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            throw new RuntimeException();
        });
        exec.shutdown();

    }

}
