//package com.example.accountmanagement.filter;
//
//import com.example.accountmanagement.model.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/account/all")
//public class Authorization extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = req.getSession();
//        Account account = (Account) session.getAttribute("currentAccount");
//        if (account != null && account.getRole().getId() == 1) {
//            chain.doFilter(req, res);
//        } else {
//        }
//    }
//}
