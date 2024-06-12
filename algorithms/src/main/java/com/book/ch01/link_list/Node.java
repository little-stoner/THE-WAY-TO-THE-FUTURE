package com.book.ch01.link_list;

public class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node<Item> getNext() {
        return next;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }

    public static void main(String[] args) {

    }
}
