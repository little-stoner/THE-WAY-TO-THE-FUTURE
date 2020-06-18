package _onjava;


import java.util.*;
import java.util.function.*;



public interface Rand {


    class String
        implements Supplier<java.lang.String> {
        SplittableRandom r = new SplittableRandom(47);
        private int strlen = 7;
        public String() {}
        public String(int strLength) { strlen = strLength; }
        public java.lang.String get() {
            return r.ints(strlen, 'a', 'z' + 1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        public java.lang.String get(int n) {
            return get();
        }
        public java.lang.String[] array(int sz) {
            java.lang.String[] result = new java.lang.String[sz];
            Arrays.setAll(result, n -> get());
            return result;
        }
    }
}
