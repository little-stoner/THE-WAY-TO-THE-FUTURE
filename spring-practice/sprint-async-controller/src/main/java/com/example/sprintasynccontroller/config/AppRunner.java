package com.example.sprintasynccontroller.config;

import com.example.sprintasynccontroller.entity.User;
import com.example.sprintasynccontroller.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final UserService userService;

    public AppRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<Optional<User>> u1 = userService.findOneByUsernameAsync("a");
        CompletableFuture<Optional<User>> u2 = userService.findOneByUsernameAsync("b");

        // Wait until they are all done
        CompletableFuture.allOf(u1, u2).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + u1.get());
        logger.info("--> " + u2.get());

    }

}
