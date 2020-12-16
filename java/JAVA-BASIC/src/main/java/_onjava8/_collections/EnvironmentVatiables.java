package _onjava8._collections;

import java.util.Map;

public class EnvironmentVatiables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
