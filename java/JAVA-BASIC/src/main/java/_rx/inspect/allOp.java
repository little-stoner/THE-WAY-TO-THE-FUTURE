package _rx.inspect;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class allOp {

    public static void main(String[] args) {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(0);
            o.onNext(10);
            o.onNext(10);
            o.onNext(2);
            o.onComplete();
        });


        Disposable evenNumbers = values
                .all(i -> i % 2 == 0)
                .subscribe(
                        (v) -> System.out.println(v),
                        e -> System.out.println("Error: " + e)
                );
    }

}
