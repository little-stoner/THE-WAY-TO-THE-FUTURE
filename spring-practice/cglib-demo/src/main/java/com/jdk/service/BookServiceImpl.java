package com.jdk.service;

public class BookServiceImpl implements BookService {

    @Override
    public void getBookById(long id) {
        System.out.printf(" found book with id = %s%n", id);
    }

}
