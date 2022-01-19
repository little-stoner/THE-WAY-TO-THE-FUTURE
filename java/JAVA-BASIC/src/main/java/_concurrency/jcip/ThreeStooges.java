package _concurrency.jcip;


import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashSet;
import java.util.Set;

@ThreadSafe
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();
    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }
    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
