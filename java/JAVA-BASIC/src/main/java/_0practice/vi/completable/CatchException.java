package _0practice.vi.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CatchException {




    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String a1 = "";
        String a2 = "";
        String a3 = "";
         CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException(" f1 ");
                });
         CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(" ##### f2222222222 ");
            return "  2222222 ";
        });
         CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(" ##### f3333333333");
            return "3333333";
        });
        CompletableFuture<Void> allFutures =
                CompletableFuture.allOf(f1, f2, f3);
//                .exceptionally(e -> {
//                    throw new RuntimeException(e);
//                });
//        Thread.sleep(1000);
//        System.out.println(allFutures.isCompletedExceptionally());
        allFutures.get();
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(" ======================= ");

    }


}
