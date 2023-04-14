package _generics.faq;

import _generics.faq.entity.Box;

public class WildcardAccess {

    static void test() {
        Box<?> box = new Box<>("abc");
        // box.put("xyz");
        box.put(null);
        // String s = box.take();
        Object s = box.take();

        // boolean equal = box.equalTo(box);
        // equal = box.equalTo(new Box<>("abc"));

        Box<?> box1 = box.copy();
        // Box<String> box2 = box.copy();
    }

    public static void main(String[] args) {

    }

}
