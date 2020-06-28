package com.test.testapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/greetings")
    public String greetings(Model model) {

        return "greetings";
    }
}
