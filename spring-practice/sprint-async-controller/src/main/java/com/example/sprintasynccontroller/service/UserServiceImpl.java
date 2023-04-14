package com.example.sprintasynccontroller.service;


import com.example.sprintasynccontroller.controller.UserController;
import com.example.sprintasynccontroller.entity.User;
import com.example.sprintasynccontroller.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CompletableFuture<Optional<User>> findOneById(String id) {
        System.out.println(">>>>>>>>>>>>>>>>>>> " + id + " <<<<<<<<<<<<<<<<<<<<<");
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(" ############> " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            return Optional.of(userRepository.findOneById(id));
        });
    }

    @Override
    @Async("executor")
    public CompletableFuture<Optional<User>> findOneByUsername(String name) {
        logger.info(">>>>>>>>>>>>>>>>>>> " + name + " <<<<<<<<<<<<<<<<<<<<<");
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println(" ===========> " + Thread.currentThread().getName());
//                Thread.sleep(5000);
//            } catch (Exception e) {
//            }
//            return Optional.of(userRepository.findOneByUsername(name));
//        });
        try {
            logger.info(" ===========> " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        return userRepository.findOneByUsernameAsync(name);
    }

    @Override
    @Async("executor")
    public CompletableFuture<Optional<User>> findOneByUsernameAsync(String name) {
        logger.info(">>>>>>>>>>>>>>>>>>> " + name + " <<<<<<<<<<<<<<<<<<<<<");
        try {
            logger.info(" ===========> " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        return userRepository.findOneByUsernameAsync(name);
    }
}
