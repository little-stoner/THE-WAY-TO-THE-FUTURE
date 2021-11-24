package com.jdk.service;

import com.jdk.proxy.Service;

public interface BookService extends Service {
    void getBookById(long id);
}
