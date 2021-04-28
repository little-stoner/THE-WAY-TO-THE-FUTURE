package com.apollo.moon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moon")
public class Moon {


    @Value("${hello:world}")
    private String world;

    @RequestMapping("/say")
    public String fetch() {
        return " hello " + world + " ! ";
    }

}
