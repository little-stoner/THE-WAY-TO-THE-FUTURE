package _rx;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Life {

    public static void subscribe() {
        Subject<Integer> s = ReplaySubject.create();
        s.subscribe(
                v -> System.out.println(v),
                e -> System.err.println(e));
        s.onNext(0);
        s.onError(new Exception("Oops"));
    }
    public static void unsubscribe() {
        Subject<Integer>  values = ReplaySubject.create();
        Disposable subscription = values.subscribe(
                v -> System.out.println(v),
                e -> System.err.println(e),
                () -> System.out.println("Done")
        );
        values.onNext(0);
        values.onNext(1);
        subscription.dispose();
        values.onNext(2);
    }
    public static void un() {
        Subject<Integer>  values = ReplaySubject.create();
        Disposable subscription1 = values.subscribe(
                v -> System.out.println("First: " + v)
        );
        Disposable subscription2 = values.subscribe(
                v -> System.out.println("Second: " + v)
        );
        values.onNext(0);
        values.onNext(1);
        subscription1.dispose();
        System.out.println("Unsubscribed first");
        values.onNext(2);
    }

    public static void main(String[] args) {
        unsubscribe();
    }

}
