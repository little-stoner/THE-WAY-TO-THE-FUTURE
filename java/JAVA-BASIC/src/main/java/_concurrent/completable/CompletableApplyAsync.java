package _concurrent.completable;

import _onjava.Timer;

import java.util.concurrent.CompletableFuture;

public class CompletableApplyAsync {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);
        System.out.println("1::: " + timer.duration());
        // with out join the program will exits before finishing its work
        System.out.println(cf.join());
        System.out.println("2::: " + timer.duration());
    }
}
