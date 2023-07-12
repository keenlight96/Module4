package com.example.task01_id8922.controller;

import com.example.task01_id8922.model.Account;
import com.example.task01_id8922.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/index")
    public String toIndex(Model model) {
        model.addAttribute("account", new Account());
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Account account) {
        if (accountService.checkAccount(account))
            return "success";
        else
            return "index";
    }
}
