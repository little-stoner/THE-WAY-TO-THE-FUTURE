package com.x;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/x")
public class XController {

    @GetMapping("/")
    public String x(Model model) {
        Map<String, Object> hello = new HashMap<>();
        hello.put("message", "Hello x");
        hello.put("dateTime", LocalDateTime.now().toString());
        model.addAttribute("hello", hello);
        return "hello";
    }

}
