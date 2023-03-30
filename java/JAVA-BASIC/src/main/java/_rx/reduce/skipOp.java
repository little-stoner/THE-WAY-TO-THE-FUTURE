package _rx.reduce;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class skipOp {

    public static void main(String[] args) {
        Observable<Integer> values = Observable.range(0, 5);

        Disposable subscription = values
                .skip(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

}
