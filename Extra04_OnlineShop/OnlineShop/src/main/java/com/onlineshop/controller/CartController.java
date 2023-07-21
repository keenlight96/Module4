package com.onlineshop.controller;

import com.onlineshop.model.Bill;
import com.onlineshop.model.Cart;
import com.onlineshop.model.User;
import com.onlineshop.service.BillService;
import com.onlineshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    BillService billService;

    @GetMapping("/user/cart")
    public String toCart(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        Bill bill = billService.getCurrentBillByUser(user);
        Cart cart = cartService.getCart(bill);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/user/pay")
    public String pay(HttpSession session, Model model, HttpServletRequest request) {
        User user = (User) session.getAttribute("currentUser");
        Bill bill = billService.getCurrentBillByUser(user);
        bill = billService.updateBill(bill, request);
        billService.pay(bill);
        model.addAttribute("bill", bill);
        return "result";
    }
}
