package _proxy;

import net.sf.cglib.core.KeyFactory;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyFactoryDemo {

    public interface SampleKeyFactory {
        Object newInstance(String first, int second);
    }

    public void testKeyFactory() throws Exception {
        SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(Key.class);
        Object key = keyFactory.newInstance("foo", 42);
        Map<Object, String> map = new HashMap<Object, String>();
        map.put(key, "Hello cglib!");
        assertEquals("Hello cglib!", map.get(keyFactory.newInstance("foo", 42)));
    }

    public static void main(String[] args) throws Exception {
        new KeyFactoryDemo().testKeyFactory();
    }
}
