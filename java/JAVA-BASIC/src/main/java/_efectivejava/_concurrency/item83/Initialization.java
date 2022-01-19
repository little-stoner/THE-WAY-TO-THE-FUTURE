package _efectivejava._concurrency.item83;

public class Initialization {

    private static class FieldType{}

    // normal initialization
    private final FieldType field = computeFieldValue();

    // Lazy initialization
    private FieldType field2;
    synchronized FieldType getField2() {
        if (field2 == null) {
            field2 = computeFieldValue();
        }
        return field2;
    }


    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }
    static FieldType getField3() {
        return FieldHolder.field;
    }

    private volatile FieldType field4;
    FieldType getField4() {
        FieldType result = field4;
        if (result == null) {
            synchronized (this) {
                result = field4;
                if (result == null) {
                    field4 = result = computeFieldValue();
                }
            }
        }
        return result;
    }


    private static FieldType computeFieldValue() {
        return new FieldType();
    }

}
