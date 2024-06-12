/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item should not be null");
        }
        if (first == null) {
            first = new Node();
            first.item = item;
            last = first;
        }
        else {
            Node newFirst = new Node();
            newFirst.item = item;
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
        N++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item should not be null");
        }
        if (last == null) {
            last = new Node();
            last.item = item;
            first = last;
        }
        else {
            Node newLast = new Node();
            newLast.item = item;
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        }
        N++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        Item item = first.item;
        Node next = first.next;
        first.next = null;
        first = next;
        N--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        Item item = last.item;
        Node prev = last.prev;
        if (prev != null) {
            prev.next = null;
        }
        //
        last.prev = null;
        last.next = null;
        last = prev;
        //
        N--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private static void r1() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.forEach(i -> System.out.print(" " + i));
        System.out.println();
        deque.addFirst(2);
        deque.forEach(i -> System.out.print(" " + i));
        System.out.println();
        deque.addLast(3);
        deque.forEach(i -> System.out.print(" " + i));
        System.out.println();
        deque.removeLast();
        deque.forEach(i -> System.out.print(" " + i));
    }

    // unit testing (required)
    public static void main(String[] args) {
        r1();
    }

}
