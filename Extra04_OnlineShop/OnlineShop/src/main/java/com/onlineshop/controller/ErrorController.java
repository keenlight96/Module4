package com.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String errorHandler(HttpServletRequest request, Model model) {
        int errorCode = (int) request.getAttribute("javax.servlet.error.status_code");
        model.addAttribute("errorCode", errorCode);
        return "error";
    }
}
