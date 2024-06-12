/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue0<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    // construct an empty randomized queue
    public RandomizedQueue0() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        if (first == null) {
            first = new Node();
            first.item = item;
            last = first;
        }
        else {
            Node next = new Node();
            next.item = item;
            last.next = next;
            last = next;
        }
        N++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        int rid = StdRandom.uniformInt(N);
        Node current = first;
        for (int i = 0; i < N; i++) {
            if (i == rid) {
                Item item = current.item;
                current.item = first.item;
                first.item = item;
            }
            else {
                current = current.next;
            }
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        int idx = StdRandom.uniformInt(N);
        Node current = first;
        for (int i = 0; i < N; i++) {
            if (i == idx) {
                break;
            }
            else {
                current = current.next;
            }
        }
        return current.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }


    private class QueueIterator implements Iterator<Item> {
        int size;
        Item[] items;

        @SuppressWarnings("unchecked")
        public QueueIterator() {
            size = N;
            items = (Item[]) new Object[N];
            Node current = first;
            for (int i = 0; i < N; i++) {
                items[i] = current.item;
                current = current.next;
            }
            for (int i = 0; i < N; i++) {
                int r = StdRandom.uniformInt(i + 1);
                exch(items, i, r);
            }
        }

        private void exch(Item[] items, int i, int r) {
            Item item = items[i];
            items[i] = items[r];
            items[r] = item;
        }

        // public boolean hasNext() {
        //     return current != null;
        // }

        // public Item next() {
        //     if (current == null) {
        //         throw new NoSuchElementException();
        //     }
        //     Item item = current.item;
        //     current = current.next;
        //     return item;
        // }


        public boolean hasNext() {
            return size > 0;
        }

        public Item next() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            return items[--size];
        }

        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    private static void t0() {
        RandomizedQueue0<Integer> queue = new RandomizedQueue0<>();
        queue.enqueue(277);
        queue.enqueue(552);
        queue.enqueue(666);
        queue.enqueue(66);
        queue.enqueue(290);
        queue.forEach(q -> System.out.print(" " + q));
    }

    // unit testing (required)
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
