/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int N;
    private Item[] items;
    private int first = 0;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    // add the item
    public void enqueue(Item item) {
        if (N == items.length) {
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        int idx = StdRandom.uniformInt(first, first + N);
        exch(first, idx);
        N--;
        return items[first++];
    }

    private void exch(int i, int r) {
        Item item = items[r];
        items[r] = item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int idx = StdRandom.uniformInt(first, first + N);
        return items[idx];
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Item[] ia = (Item[]) new Object[N];
        private int first;

        public QueueIterator() {
            for (int i = 0; i < N; i++) {
                ia[i] = items[i];
            }
            for (int i = 0; i < N; i++) {
                int idx = StdRandom.uniformInt(0, i);
                exch(i, idx);
            }
        }

        public boolean hasNext() {
            return first < ia.length;
        }

        public Item next() {
            return ia[first++];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        RandomizedQueue0<Integer> queue = new RandomizedQueue0<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }
    }
}
