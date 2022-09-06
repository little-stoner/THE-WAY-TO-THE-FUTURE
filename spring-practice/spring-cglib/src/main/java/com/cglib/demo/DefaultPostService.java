package com.cglib.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultPostService implements PostService {

    private final String name;
    private final PostRepository postRepository;
    private final LogService logService;


    public DefaultPostService(String name, PostRepository postRepository, LogService logService) {
        this.name = name;
        this.postRepository = postRepository;
        this.logService = logService;
    }

    @Override
    public void save() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public String getName() {
        return name;
    }

    public PostRepository getPostRepository() {
        return postRepository;
    }

    public LogService getLogService() {
        return logService;
    }
}
