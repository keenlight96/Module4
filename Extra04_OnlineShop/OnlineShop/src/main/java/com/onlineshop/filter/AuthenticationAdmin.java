package com.onlineshop.filter;

import com.onlineshop.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthenticationAdmin extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser != null && currentUser.getRole().getRole().equals("Admin")) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/product");
        }
    }
}
