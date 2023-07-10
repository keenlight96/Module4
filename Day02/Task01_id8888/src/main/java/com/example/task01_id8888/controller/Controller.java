package com.example.task01_id8888.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Controller
public class Controller {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public Pattern pattern;
    public Matcher matcher;

    public Controller() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }

    @PostMapping("/index")
    public String handler(@RequestParam String email, Model model) {
        if (check(email)) {
            model.addAttribute("result", "success");
        } else {
            model.addAttribute("result", "fail");
        }
        return "result";
    }

    public boolean check(String text) {
        matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
