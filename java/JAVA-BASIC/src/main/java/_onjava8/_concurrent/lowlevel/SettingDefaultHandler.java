package _onjava8._concurrent.lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        ExecutorService es =
                Executors.newCachedThreadPool();
        es.execute(new ExceptionThread2());
        es.shutdown();
    }
}
