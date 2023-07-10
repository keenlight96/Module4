package com.example.task07_id8893.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculateController {
    @GetMapping()
    public String toIndex() {
        return "index";
    }

    @GetMapping("calculate")
    public String calculate(int number1, int number2, String button, Model model) {
        int result = 0;
        if (button.equals("add"))
            result = number1 + number2;
        else if (button.equals("subtract"))
            result = number1 - number2;
        else if (button.equals("multiple"))
            result = number1 * number2;
        else if (button.equals("divide"))
            result = number1 / number2;
        model.addAttribute("result", result);
        return "result";
    }
}
