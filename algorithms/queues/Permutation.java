/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {

    public Permutation() {
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        if (N <= 0) {
            return;
        }
        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String in = StdIn.readString();
            deque.addFirst(in);
        }
        // int N = 3;
        // Scanner scanner = new Scanner(new File("./distinct.txt"));
        // Deque<String> deque = new Deque<>();
        // while (scanner.hasNext()) {
        //     String in = scanner.next();
        //     deque.addFirst(in);
        // }

        while (N > 0) {
            int size = deque.size();
            int rd = StdRandom.uniformInt(size);
            for (int i = 0; i < size; i++) {
                String item = deque.removeFirst();
                if (i == rd) {
                    System.out.println(item);
                }
                else {
                    deque.addLast(item);
                }
            }
            N--;
        }
    }
}
