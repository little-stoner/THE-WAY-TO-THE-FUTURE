package _rx;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class ASubject {

    public static void async() {
        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(v -> System.out.println(v));
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onComplete();
    }

    public static void main(String[] args) {
        async();
    }

}
