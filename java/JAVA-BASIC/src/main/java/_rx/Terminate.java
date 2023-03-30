package _rx;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.ReplaySubject;

import javax.security.auth.Subject;

public class Terminate {

    public static void main(String[] args) {
        ReplaySubject<Integer> values = ReplaySubject.create();
        Disposable subscription1 = values.subscribe(
                v -> System.out.println("First: " + v),
                e -> System.out.println("First: " + e),
                () -> System.out.println("Completed")
        );
        values.onNext(0);
        values.onNext(1);
        values.onComplete();
        values.onNext(2);
    }

}
