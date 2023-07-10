package com.example.task06_id8892.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckboxController {
    @GetMapping()
    public String toIndex() {
        return "index";
    }

    @GetMapping("save")
    public String save(@RequestParam(name = "ingredient") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "result";
    }
}
