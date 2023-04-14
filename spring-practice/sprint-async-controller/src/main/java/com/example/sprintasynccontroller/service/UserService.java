package com.example.sprintasynccontroller.service;


import com.example.sprintasynccontroller.entity.User;


import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<Optional<User>> findOneById(final String id);

    CompletableFuture<Optional<User>> findOneByUsername(final String name);
    CompletableFuture<Optional<User>> findOneByUsernameAsync(final String name);

}
