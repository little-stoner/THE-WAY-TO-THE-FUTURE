package _compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author viber
 */

public class Comparator {

    static class Ctr implements java.util.Comparator<Ctr> {
        private int id;
        public Ctr() {}
        public Ctr(int id) { this.id = id; }
        @Override
        public int compare(Ctr o1, Ctr o2) {
            return Integer.compare(o2.id,  o1.id);
        }
        @Override
        public String toString() {
            return "Ctr{" +
                    "id=" + id +
                    '}';
        }

        public static void main(String[] args) {
            List<Ctr> ctrList = Arrays.asList(
                new Ctr(0), new Ctr(1),
                new Ctr(2), new Ctr(3),
                new Ctr(6), new Ctr(9)
            );
            Collections.sort(ctrList, new Ctr());
            System.out.println(
                    ctrList
            );
        }
    }

}
