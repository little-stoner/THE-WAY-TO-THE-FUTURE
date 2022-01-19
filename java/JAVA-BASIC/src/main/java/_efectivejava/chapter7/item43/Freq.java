package _efectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author viber
 */
public class Freq {

    public static void main(String[] args) {
        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : args) {
            frequencyTable.merge(s, 1, (count, incr) -> count + incr); // Lambda
        }
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for (String s : args) {
            frequencyTable.merge(s, 1, Integer::sum); // Method reference
        }
        System.out.println(frequencyTable);

    }

}
