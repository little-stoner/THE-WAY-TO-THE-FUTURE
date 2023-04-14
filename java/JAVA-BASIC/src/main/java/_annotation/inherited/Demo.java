package _annotation.inherited;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Demo extends Super {
    public static void main(String[] arg) throws Exception {
        new Super();
        Class<Super> obj = Super.class;
        getstateinfo(obj);
        System.out.println("=================================================");
        Method m = obj.getMethod("getstateinfo", new Class[]{});
        getstateinfo(m);
    }

    static void getstateinfo(AnnotatedElement e) {
        try {
            System.out.println("Finding annotations on " + e.getClass().getName());
            Annotation[] annotations = e.getAnnotations();
            for (Annotation a : annotations) {
                if (a instanceof MyAnnotation) {
                    MyAnnotation stateInfo = (MyAnnotation) a;
                    System.out.println("Name of Annotation :" + stateInfo.annotationType());
                    System.out.println("State Name :" + stateInfo.name());
                    System.out.println("State code :" + stateInfo.code());
                    System.out.println(new Demo().getClass().getAnnotation(MyAnnotation.class));
                    System.out.println(new Super().getClass().getAnnotation(MyAnnotation.class));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
