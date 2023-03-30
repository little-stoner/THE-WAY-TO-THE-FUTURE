package _8;

import java.util.function.Function;

public class Func {

    Function<Object, String> f = new Function<Object, String>() {
        @Override
        public String apply(Object o) {
            return o.toString();
        }
    };

    Function<Object, String> ff = o -> o.toString();

    Function<Object, String> fff = Object::toString;

}
