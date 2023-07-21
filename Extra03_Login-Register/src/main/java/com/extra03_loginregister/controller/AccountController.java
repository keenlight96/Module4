package com.extra03_loginregister.controller;

import com.extra03_loginregister.model.Account;
import com.extra03_loginregister.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String toRegister(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @PostMapping("/register")
    public String register(Account account, @RequestParam MultipartFile imgAvatar, int roleId) {
        accountService.save(account, imgAvatar, roleId);
        return "login";
    }

    @GetMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(Account account, Model model) {
        Account loggedIn = accountService.getLogin(account);
        if (loggedIn !=null) {
            model.addAttribute("account", loggedIn);
            return "success";
        }
        else
            return "redirect:/login";
    }
}
