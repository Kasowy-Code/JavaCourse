package com.example.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {
    @GetMapping("/hello")
    @ResponseBody
    String hello(@RequestParam(required = false, defaultValue = "stranger") String name) {
        return "Hello " + name;
    }
}
