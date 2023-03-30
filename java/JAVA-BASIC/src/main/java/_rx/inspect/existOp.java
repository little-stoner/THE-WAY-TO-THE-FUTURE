package _rx.inspect;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class existOp {

    public static void main(String[] args) {
        Observable<Integer> values = Observable.range(0, 2);

        Disposable subscription = values
                .any(i -> i > 2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e)
                );
    }

}
