package com.example.sprintasynccontroller.controller;


import com.example.sprintasynccontroller.entity.User;
import com.example.sprintasynccontroller.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public CompletableFuture<ResponseEntity> getUsers(@PathVariable String userId) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        CompletableFuture<ResponseEntity> rsp = userService.findOneById(userId)
                .thenApply(mapMaybeUserToResponse)
                .exceptionally(handleGetUserFailure.apply(userId));
        CompletableFuture<ResponseEntity> r0 = userService.findOneById("2")
                .thenApply(mapMaybeUserToResponse)
                .exceptionally(handleGetUserFailure.apply("2"));
        CompletableFuture.allOf(rsp, r0);
        System.out.println("===================>" + rsp);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        return rsp;
    }

    @GetMapping("/name/{name}")
    public CompletableFuture<Optional<User>> fetchUser(@PathVariable String name) {
        System.out.println("--------------------------------------------------------");
        CompletableFuture<Optional<User>> user = userService.findOneByUsername(name);
        CompletableFuture<Optional<User>> userb = userService.findOneByUsername("b");

        CompletableFuture.allOf(user, userb);
        System.out.println(" user: " + user);
        System.out.println(" userb: " + userb);

        System.out.println("===================************************************");
        return user;
    }

    @GetMapping("/async")
    public String runAsync() {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("((((((((((((()))))))))))))))(((((((((((((())))))))");
        });
        return "async";
    }

    @GetMapping("/thread")
    public String thread() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("###################################@@@@@@@@@@@##############################");
        }).start();
        return "thread";
    }

    private static Function<Optional<User>, ResponseEntity> mapMaybeUserToResponse = maybeUser -> maybeUser
            .<ResponseEntity>map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    private static Function<String, Function<Throwable, ResponseEntity>> handleGetUserFailure = userId -> throwable -> {
        logger.error(String.format("Unable to retrieve user for id: %s", userId), throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    };


}
