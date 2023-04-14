package _annotation;


import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;




public class Util {

    private interface AnnotationFilter {
        AnnotationFilter PLAIN = packages("java.lang", "org.springframework.lang");
        AnnotationFilter JAVA = packages("java", "javax");
        AnnotationFilter ALL = new AnnotationFilter() {
            @Override
            public boolean matches(Annotation annotation) {
                return true;
            }
            @Override
            public boolean matches(Class<?> type) {
                return true;
            }
            @Override
            public boolean matches(String typeName) {
                return true;
            }
            @Override
            public String toString() {
                return "All annotations filtered";
            }
        };
        default boolean matches(Annotation annotation) {
            return matches(annotation.annotationType());
        }
        default boolean matches(Class<?> type) {
            return matches(type.getName());
        }

        boolean matches(String typeName);


        /**
         * Create a new {@link AnnotationFilter} that matches annotations in the
         * specified packages.
         * @param packages the annotation packages that should match
         * @return a new {@link AnnotationFilter} instance
         */
        static AnnotationFilter packages(String... packages) {
            return new PackagesAnnotationFilter(packages);
        }
    }

    final static class PackagesAnnotationFilter implements AnnotationFilter {

        private final String[] prefixes;

        private final int hashCode;


        PackagesAnnotationFilter(String... packages) {
            // Assert.notNull(packages, "Packages array must not be null");
            this.prefixes = new String[packages.length];
            for (int i = 0; i < packages.length; i++) {
                String pkg = packages[i];
                // Assert.hasText(pkg, "Packages array must not have empty elements");
                this.prefixes[i] = pkg + ".";
            }
            Arrays.sort(this.prefixes);
            this.hashCode = Arrays.hashCode(this.prefixes);
        }


        @Override
        public boolean matches(String annotationType) {
            for (String prefix : this.prefixes) {
                if (annotationType.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }


        @Override
        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            return Arrays.equals(this.prefixes, ((PackagesAnnotationFilter) other).prefixes);
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }

        @Override
        public String toString() {
            return "Packages annotation filter: " + "";
                    // StringUtils.arrayToCommaDelimitedString(this.prefixes);
        }

    }

    private static final AnnotationFilter JAVA_LANG_ANNOTATION_FILTER =
            AnnotationFilter.packages("java.lang.annotation");

    public static <A extends Annotation> A findAnnotation(Class<?> clazz, Class<A> annotationType) {
        return findAnnotation(clazz, annotationType, new HashSet<Annotation>());
    }

    @SuppressWarnings("unchecked")
    private static <A extends Annotation> A findAnnotation(Class<?> clazz, Class<A> annotationType, Set<Annotation> visited) {
        try {
            Annotation[] anns = clazz.getDeclaredAnnotations();
            for (Annotation ann : anns) {
                if (ann.annotationType() == annotationType) {
                    return (A) ann;
                }
            }
            for (Annotation ann : anns) {
                if (!isInJavaLangAnnotationPackage(ann) && visited.add(ann)) {
                    A annotation = findAnnotation(ann.annotationType(), annotationType, visited);
                    if (annotation != null) {
                        return annotation;
                    }
                }
            }
        }
        catch (Exception ex) {
            // handleIntrospectionFailure(clazz, ex);
            return null;
        }

        for (Class<?> ifc : clazz.getInterfaces()) {
            A annotation = findAnnotation(ifc, annotationType, visited);
            if (annotation != null) {
                return annotation;
            }
        }

        Class<?> superclass = clazz.getSuperclass();
        if (superclass == null || Object.class == superclass) {
            return null;
        }
        return findAnnotation(superclass, annotationType, visited);
    }

    public static boolean isInJavaLangAnnotationPackage(@Nullable Annotation annotation) {
        return (annotation != null && JAVA_LANG_ANNOTATION_FILTER.matches(annotation));
    }

}
