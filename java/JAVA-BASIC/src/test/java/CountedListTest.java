import _onjava.atunit.Test;
import _onjava8._validating.CountedList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CountedListTest {
    private CountedList list;
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(" >>> Starting CountedListTest ");
    }
    @AfterAll
    public void afterAllMsg() {
        System.out.println(" >>> Finish CountedListTest");
    }

    @BeforeEach
    public void initialize() {
        list = new CountedList();
        System.out.println(" Set up for " + list.getId());
        for (int i=0; i < 3; i++)
            list.add(Integer.toString(i));
    }

    @AfterEach
    public void cleanup() {
        System.out.println(" cleaning up " + list.getId());
    }

    @Test
    public void replace() {
        System.out.println(" Running testReplace() ");
        assertEquals(list.size(), 3);
        list.set(1, "Replace");
        assertEquals(list.size(), 3);
        assertEquals(list.get(1), "Replace");
    }

    private void compare(List<String> lst, String[] strs) {
        assertArrayEquals(lst.toArray(new String[0]), strs);
    }

    public void order() {
        System.out.println(" Running testOrder() ");
        compare(list, new String[] { "0", "1", "2" });
    }

    @Test
    public void remove() {
        System.out.println(" Running testRemove() ");
        assertEquals(list.size(), 3);
        list.remove(1);
        assertEquals(list.size(), 2);
        compare(list, new String[] {"0", "2"});
    }
    @Test
    public void addAll() {
        System.out.println(" Running testAddALl()");
        list.addAll(Arrays.asList(new String[] { "An", "African", "Swallow" }));
        assertEquals(list.size(), 6);
        compare(list, new String[] { "0", "1", "2", "An", "African", "Swallow" });
    }

}
