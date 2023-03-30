package _rx.reduce;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class takeOp {

    public static void main(String[] args) {
        Observable<Integer> values = Observable.range(0, 5);

        Disposable first2 = values
                .take(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );

         values = Observable.create(o -> {
            o.onNext(1);
            o.onError(new Exception("Oops"));
        });

        Disposable subscription = values
                .take(1)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

}
