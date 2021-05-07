
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(URL path) throws MalformedURLException {
        super(new URL[]{path});
    }

    public CustomClassLoader(URL path, ClassLoader parent) throws MalformedURLException {
        super(new URL[]{path}, parent);
    }

}
