package _efectivejava._serialization.item87;

import java.io.Serializable;

public class Name implements Serializable {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    public Name() {
        this.lastName = null;
        this.firstName = null;
        this.middleName = null;
    }
}
