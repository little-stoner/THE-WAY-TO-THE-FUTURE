package _innerclasses;

public class Parcel9 {


    public Destination destination(final String dest) {
                                    // final or effectively final
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                 // dest = "A";
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("AA");
    }
}
