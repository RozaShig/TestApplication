package com.test.testapplication;

import com.test.testapplication.params.NumberSystemParams;
import com.test.testapplication.service.NumberSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberSystemController {

    @Autowired
    private NumberSystemService numberSystemService;

    @GetMapping("/task/1")
    public String getNumberSystem() {
        return "numberSystemPost";
    }

    @PostMapping("/task/1")
    public String numberSystem(@RequestParam Integer number, @RequestParam Integer base, Model model) {
        NumberSystemParams params = new NumberSystemParams(number, base);
        model.addAttribute("resultValue", numberSystemService.getFromDec(params));
        return "result";
    }
}
