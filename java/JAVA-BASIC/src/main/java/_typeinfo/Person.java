package _typeinfo;

import java.util.Optional;

public class Person {

    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;

    public final boolean empty;

    Person(String first, String last, String address) {
        this.first = Optional.ofNullable(first);
        this.last = Optional.of(last);
        this.address = Optional.ofNullable(address);
        empty = !this.first.isPresent() && !this.last.isPresent() && !this.address.isPresent();
    }

    Person(String first, String last) {
        this(first, last, null);
    }

    Person(String last) {
        this(null, last, null);
    }

    Person() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        return "Person{" +
                "first=" + first +
                ", last=" + last +
                ", address=" + address +
                ", empty=" + empty +
                '}';
    }
}
