package _rx.reduce;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class filterOp {
    public static void filter() {
        Observable<Integer> values = Observable.range(0,10);
        Disposable oddNumbers = values
                .filter(v -> v % 2 == 0)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }
    public static void main(String[] args) {
        filter();
    }
}
