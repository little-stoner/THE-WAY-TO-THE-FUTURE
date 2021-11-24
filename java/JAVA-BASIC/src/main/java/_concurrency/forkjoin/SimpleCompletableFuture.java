package _concurrency.forkjoin;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SimpleCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        while (true) {
//            System.out.println(">>>>>>>>>. start");
//            CompletableFuture.supplyAsync(() -> {
//                System.out.println(Thread.currentThread());
//                Object r = CompletableFuture.supplyAsync(() -> {
//                    System.out.println("@@@@@@@@@@@@@@@@@@@");
//                    return "inner";
//                });
//                System.out.println("()))))))))))))))))))) " + r);
//                return "";
//            });
            System.out.println("=====================");
            Thread mainThread = Thread.currentThread();
            System.out.println(">>>>>>>>>>>" + mainThread.getState());
            CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=========>" + mainThread.getState());
                throw new RuntimeException("~~~~~~~~~~~~~~");
            }).exceptionally(e -> {
                System.out.println(">>>>>>>>>>" + e);
                return "EEEE";
            });
            //TimeUnit.SECONDS.sleep(1);
            Object result = completableFuture.get();
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        }
    }

}
