
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {

        String url = "/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/spring-practice/class-loader-demo/D";
        URL path = new File(url).toURI().toURL();

	    System.out.println(">>>>>>>>> " + System.getProperty("java.class.path"));

        CustomClassLoader customClassLoaderA = new CustomClassLoader(path);

        Class<?> classA = customClassLoaderA.loadClass("A");
        Method load = classA.getMethod("load");
        Object instanceA = classA.newInstance();
        load.invoke(instanceA);

        System.out.println(customClassLoaderA);
        System.out.println("classA@" + classA.hashCode());

        System.out.println(" ======================================== ");

        CustomClassLoader customClassLoaderB = new CustomClassLoader(path, customClassLoaderA);
        Class<?> classA0 = customClassLoaderB.loadClass("A");
        Method load0 = classA0.getMethod("load");
        Object instanceA0 = classA0.newInstance();
        load0.invoke(instanceA0);
        System.out.println(customClassLoaderB);
        System.out.println("classA0@" + classA0.hashCode());

        System.out.println(" ======================================= ");

        CustomClassLoader customClassLoaderC = new CustomClassLoader(path);
        Class<?> classA1 = customClassLoaderC.loadClass("A");
        Method load1 = classA1.getMethod("load");
        Object instanceA1 = classA1.newInstance();
        load1.invoke(instanceA1);
        System.out.println(customClassLoaderC);
        System.out.println("classA1@" + classA1.hashCode());

        System.out.println(" ========================================= ");

        System.out.println("classA == classA0 " + (classA == classA0));
        System.out.println("classA == classA1 " + (classA == classA1));
        System.out.println(" ========================================= ");

    }
}
