package _annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Composition
public class Anno {

    public static void main(String[] args) {
        Annotation[] annotations = Composition.class.getAnnotations();
        System.out.println(
                Arrays.toString(annotations)
        );
        Anno anno = new Anno();
        System.out.println(
                Arrays.toString(anno.getClass().getAnnotations())
        );
        System.out.println(
                Arrays.toString(Anno.class.getAnnotations())
        );
        System.out.println(
                Arrays.toString(Anno.class.getDeclaredAnnotations())
        );
        System.out.println(
                Anno.class.getDeclaredAnnotation(A.class)
        );
        Composition c = Anno.class.getAnnotation(Composition.class);
        System.out.println(
                Arrays.toString(c.getClass().getAnnotations())
        );
    }

}
