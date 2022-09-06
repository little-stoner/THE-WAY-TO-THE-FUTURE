package com.cglib.demo;

public class DefaultPostRepository implements PostRepository {
    @Override
    public void save() {
        System.out.println("Saving...");
    }
}
