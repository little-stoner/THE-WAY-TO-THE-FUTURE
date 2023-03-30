package com.book.ch03;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;    
    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color;
        int N;
        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    public void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size() {
        return size(root);
    }
    public int size(Node root) {
        if (root == null) return 0;
        return root.N;
    }

    public void put(Key key, Value val) {
        root = put(root , key, val);
        root.color = BLACK;
    }

    public Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColor(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;

    }

    
}
