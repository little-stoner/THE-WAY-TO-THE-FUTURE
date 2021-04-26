package com.stone.db.sqlinjection.controller;


import com.stone.db.sqlinjection.core.Result;
import com.stone.db.sqlinjection.entity.User;
import com.stone.db.sqlinjection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/s-query")
    public Result sQuery(@RequestParam String username) {
        return userService.sQuery(username);
    }

    @GetMapping("/ps-query")
    public Result psQuery(@RequestParam String username) {
        return userService.psQuery(username);
    }

    @RequestMapping("/fly")
    public String fly() {
        return "fly";
    }

}
