package _compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author viber
 */

public class Comparable {

    static class Cble implements java.lang.Comparable<Cble> {
        private int id;
        public Cble(int id) { this.id = id; }
        @Override
        public int compareTo(Cble o) {
            return Integer.compare(o.id, this.id);
        }

        @Override
        public String toString() {
            return "Cble{" +
                    "id=" + id +
                    '}';
        }

        public static void main(String[] args) {
            List<Cble> cbleList = Arrays.asList(
                new Cble(0), new Cble(1),
                new Cble(2), new Cble(3),
                new Cble(4), new Cble(8)
            );
            Collections.sort(cbleList);
            System.out.println(
                    cbleList
            );
        }
    }

}
