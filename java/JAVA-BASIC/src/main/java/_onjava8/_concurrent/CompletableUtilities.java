package _onjava8._concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableUtilities {
    public static void shower(CompletableFuture<?> c) {
        try {
            System.out.println(c.get());
        } catch (InterruptedException
                |ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void voidr(CompletableFuture<Void> c) {
        try {
            c.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
