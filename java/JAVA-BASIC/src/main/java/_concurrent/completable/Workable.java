package _concurrent.completable;

import _onjava.Nap;

import java.util.concurrent.CompletableFuture;

public class Workable {

    String id;
    final double duration;
    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable{" +
                "id='" + id + '}';
    }

    public static Workable work(Workable tt) {
        new Nap(tt.duration);
        tt.id = tt.id + "w";
        System.out.println(tt);
        return tt;
    }

    public static CompletableFuture<Workable> make(String id, double duration) {
        return CompletableFuture.completedFuture(new Workable(id, duration)).thenApplyAsync(Workable::work);
    }

}
