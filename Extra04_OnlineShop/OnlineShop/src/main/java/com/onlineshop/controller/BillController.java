package com.onlineshop.controller;

import com.onlineshop.model.Bill;
import com.onlineshop.model.BillDetail;
import com.onlineshop.model.Product;
import com.onlineshop.model.User;
import com.onlineshop.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/bill/add")
    public String add(@RequestParam("id") Product product, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        Bill bill = billService.getCurrentBillByUser(user);
        billService.add(bill, product);
        return "redirect:/product";
    }
}
