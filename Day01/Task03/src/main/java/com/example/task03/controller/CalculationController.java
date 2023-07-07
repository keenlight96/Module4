package com.example.task03.controller;

import com.example.task03.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculationController {
    @Autowired
    CalculationService calculationService;

    @GetMapping("/calculate")
    public String getResult(double usd, double rate, Model model) {

        double result = calculationService.calculate(usd, rate);
        model.addAttribute("result", result);
        return "/result";
    }
}
