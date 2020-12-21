package _0practice.vi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@java.lang.annotation.Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedAnnotationType {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UninheritedAnnotationType {

}

@UninheritedAnnotationType
class A {}

@InheritedAnnotationType
class B extends A {}

class C extends B {}

public class Inherited {
    public static void main(String[] args) {
        System.out.println(new A().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(new B().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(new C().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println("_________________________________");
        System.out.println(new A().getClass().getAnnotation(UninheritedAnnotationType.class));
        System.out.println(new B().getClass().getAnnotation(UninheritedAnnotationType.class));
        System.out.println(new C().getClass().getAnnotation(UninheritedAnnotationType.class));
    }
}
