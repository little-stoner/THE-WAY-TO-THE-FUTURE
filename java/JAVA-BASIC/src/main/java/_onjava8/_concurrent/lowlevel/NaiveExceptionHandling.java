package _onjava8._concurrent.lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {
    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        try {
            es.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.println(" Exception was handled! ");
        } finally {
            es.shutdown();
        }
    }
}
