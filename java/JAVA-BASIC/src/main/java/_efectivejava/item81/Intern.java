package _efectivejava.item81;

import java.util.concurrent.ConcurrentHashMap;

public class Intern {

    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

//    public static String intern(String s) {
//        String previousValue = map.putIfAbsent(s, s);
//        return previousValue == null ? s : previousValue;
//    }

    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }

}
