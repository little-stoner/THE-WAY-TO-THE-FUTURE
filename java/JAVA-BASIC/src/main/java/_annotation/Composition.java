package _annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@A
@B
@Retention(RetentionPolicy.RUNTIME)
public @interface Composition {
    String value() default "";
}
