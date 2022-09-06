package _classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        URLClassLoader loader = new URLClassLoader(new URL[] {
            // new File("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_classloader/").toURI().toURL()
            new File("/Users/viber/Downloads/classes/").toURI().toURL()
        });
        Class c = loader.loadClass("Tester.class");
        Object o = c.newInstance();
        System.out.println(">>>>>>>>" + o.toString());
    }

}
