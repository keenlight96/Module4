package com.extra02studentmanagement.controller;

import com.extra02studentmanagement.model.Account;
import com.extra02studentmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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
    public String toAdd(Model model) {
        model.addAttribute("account", new Account());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Account account, @RequestParam MultipartFile imgAvatar) {
        String name = imgAvatar.getOriginalFilename();
        try {
            imgAvatar.transferTo(new File("G:\\My Drive\\Study\\Codegym\\Module4\\Extra02-StudentManagement\\src\\main\\webapp\\imgs\\" + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        account.setAvatar("/imgs/" + name);
        accountService.addAccount(account);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Account account, @RequestParam MultipartFile imgAvatar) {
        String name = imgAvatar.getOriginalFilename();
        try {
            imgAvatar.transferTo(new File("G:\\My Drive\\Study\\Codegym\\Module4\\Extra02-StudentManagement\\src\\main\\webapp\\imgs\\" + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        account.setAvatar("/imgs/" + name);
        accountService.editAccount(account);
        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable int id) {
        accountService.removeAccountById(id);
        return "redirect:/home";
    }

}
