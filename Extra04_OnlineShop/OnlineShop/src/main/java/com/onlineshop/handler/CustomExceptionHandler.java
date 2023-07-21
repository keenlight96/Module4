package com.onlineshop.handler;

import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model){
        e.printStackTrace();
        model.addAttribute("errorCode", e.getMessage());
        return "error";
    }
    @ExceptionHandler(Throwable.class)
    public String handleAnyException(Throwable ex, HttpServletRequest request) {
        return ClassUtils.getShortName(ex.getClass());
    }
}
