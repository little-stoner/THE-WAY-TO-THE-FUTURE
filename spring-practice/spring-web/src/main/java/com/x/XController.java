package com.x;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class XController {

    @RequestMapping(value = "/x", method = RequestMethod.GET)
    public String x(Model model) {
        model.addAttribute("message", "SpringMVC Web Hello World!");
        return "hello";
    }

}
