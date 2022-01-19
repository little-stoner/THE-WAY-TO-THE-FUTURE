package _efectivejava.chapter6.item39;


import java.lang.annotation.*;

/**
 * @author viber
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}