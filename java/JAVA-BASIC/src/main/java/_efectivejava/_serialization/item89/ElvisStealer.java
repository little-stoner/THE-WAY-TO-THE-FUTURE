package _efectivejava._serialization.item89;

import java.io.Serializable;

public class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis paylod;
    private Object readResolve() {
        impersonator = paylod;
        return new String[] { "A Fool Such AS I" };
    }
    private static final long serialVersionUID = 0;
}
