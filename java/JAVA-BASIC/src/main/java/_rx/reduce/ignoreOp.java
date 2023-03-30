package _rx.reduce;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class ignoreOp {

    public static void main(String[] args) {
        Observable<Integer> values = Observable.range(0, 10);

        Disposable subscription = values
                .ignoreElements()
                .subscribe(
                        () -> System.out.println("Completed"),
                        e -> System.out.println("Error: " + e)
                );
    }

}
