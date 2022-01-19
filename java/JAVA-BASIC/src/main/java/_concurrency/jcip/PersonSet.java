package _concurrency.jcip;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashSet;
import java.util.Set;

@ThreadSafe
public class PersonSet {

    static class Person{}
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();
    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }
    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

}
