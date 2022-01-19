package _concurrency.jcip;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Preloader {
    static class ProductInfo {
    }
    ProductInfo loadProductInfo() {
        return null;
    }

    private final FutureTask<ProductInfo> future =
            new FutureTask<>(new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws Exception {
                    return loadProductInfo();
                }
            });
    private final Thread thread = new Thread(future);

    public void start() { thread.start(); }

    public ProductInfo get() throws Exception {
        try {
            return future.get();
        } catch (Exception e) {
            Throwable cause = e.getCause();
            throw new Exception();
        }
    }

}
