package _rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.io.IOException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Sequence {

    public static void just() {
        Observable<String> values = Observable.just("one", "two", "three");
        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }
    public static void empty() {
        Observable<String> values = Observable.empty();
        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }
    public static void never() {
        Observable<String> values = Observable.never();
        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }
    public static void defer() throws InterruptedException {
        Observable<Long> now = Observable.defer(() ->
                Observable.just(System.currentTimeMillis()));

        now.subscribe(System.out::println);
        Thread.sleep(1000);
        now.subscribe(System.out::println);
    }

    public static void create() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("Hello");
            o.onComplete();
        });
        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }
    public static void range() {
        Observable<Integer> values = Observable.range(10, 15);
        values.subscribe(System.out::println);
    }
    public static void interval() throws IOException {
        Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        System.in.read();
    }

    public static void timer() throws IOException {
        Observable<Long> values = Observable.timer(1, TimeUnit.SECONDS);
        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        System.in.read();
    }

    public static void from() {
        FutureTask<Integer> f = new FutureTask<Integer>(() -> {
            Thread.sleep(2000);
            return 21;
        });
        new Thread(f).start();

        Observable<Integer> values = Observable.fromFuture(f);

        Disposable subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }

    public static void main(String[] args) throws IOException {
        // just();
        // empty();
        from();
    }

}
