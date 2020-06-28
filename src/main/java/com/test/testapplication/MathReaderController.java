package com.test.testapplication;

import com.test.testapplication.service.MathReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathReaderController {

    @Autowired
    private MathReaderService mathReaderService;

    @GetMapping("/task/2")
    public String getMathReader() {
        return "mathReaderPost";
    }

    @PostMapping("/task/2")
    public String mathReader(@RequestParam String path, Model model) {
        model.addAttribute("resultValue", mathReaderService.doTask(path));
        return "result";
    }
}
