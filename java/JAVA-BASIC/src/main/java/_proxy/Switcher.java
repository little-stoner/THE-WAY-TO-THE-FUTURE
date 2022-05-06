package _proxy;

import net.sf.cglib.util.StringSwitcher;

public class Switcher {

    public static void main(String[] args) {
        String[] strings = new String[] {"one", "two"};
        int[] values = new int[] { 10, 20 };
        StringSwitcher stringSwitcher = StringSwitcher.create(strings, values, true);
        System.out.println(stringSwitcher.intValue("one"));
        System.out.println(stringSwitcher.intValue("two"));
        System.out.println(stringSwitcher.intValue("three"));
    }

}
