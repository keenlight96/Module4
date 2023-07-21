package com.onlineshop.controller;

import com.onlineshop.model.User;
import com.onlineshop.service.BillService;
import com.onlineshop.service.UserService;
import com.onlineshop.validate.UserValidate;
import com.onlineshop.validate.group.LoginInfo;
import com.onlineshop.validate.group.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserValidate userValidate;
    @Autowired
    BillService billService;

    @GetMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User user1 = userService.checkLogin(user);
        if (user1 == null) {
            model.addAttribute("wrongLogin", "Wrong username or password");
            return "login";
        } else {
            session.setAttribute("currentUser", user1);
            billService.mustHaveBill(user1);
            return "redirect:/product";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("currentUser", null);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String toRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Validated({LoginInfo.class, UserInfo.class}) @ModelAttribute("user") User user,
                           BindingResult bindingResult) {
        userValidate.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            userService.add(user);
            return "redirect:/login";
        }
    }
}
