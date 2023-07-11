package com.extra02studentmanagement.controller;

import com.extra02studentmanagement.model.Account;
import com.extra02studentmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/home")
    public String toHome(Model model) {
        model.addAttribute("accounts", accountService.getAccounts());
        return "home";
    }

    @GetMapping("/add")
    public String toAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Account account) {
        accountService.addAccount(account);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Account account) {
        accountService.editAccount(account);
        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable int id) {
        accountService.removeAccountById(id);
        return "redirect:/home";
    }

}
