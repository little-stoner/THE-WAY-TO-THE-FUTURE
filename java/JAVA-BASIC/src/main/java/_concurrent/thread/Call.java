package _concurrent.thread;

import java.util.concurrent.*;

public class Call implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "KKK";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> r = es.submit(new Call());
        es.shutdown();
        System.out.println(r.get());
    }
}
