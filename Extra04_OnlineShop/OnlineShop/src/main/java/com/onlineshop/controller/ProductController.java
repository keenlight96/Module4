package com.onlineshop.controller;

import com.onlineshop.model.Comment;
import com.onlineshop.model.Product;
import com.onlineshop.model.Rating;
import com.onlineshop.model.User;
import com.onlineshop.service.BillService;
import com.onlineshop.service.CommentService;
import com.onlineshop.service.ProductService;
import com.onlineshop.service.RatingService;
import com.onlineshop.validate.ProductValidate;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller

public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CommentService commentService;
    @Autowired
    ProductValidate productValidate;
    @Autowired
    BillService billService;
    @Autowired
    RatingService ratingService;
    @Autowired
    HttpSession session;

    @GetMapping("/product")
    public String toProducts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("products", productService.getProducts(PageRequest.of(page, 4)));
        return "product";
    }

    @GetMapping("/product/detail")
    public String toProductDetail(@RequestParam("id") Product product, Model model) {
        model.addAttribute("product", product);
        model.addAttribute("comments", commentService.findAllByProduct(product));
        model.addAttribute("productRating", ratingService.getAverageRating(product));

        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            if (productService.isBought(product, user)) {
                model.addAttribute("isBought", true);
                model.addAttribute("comment", new Comment());
            }

            Rating rating = ratingService.findByUserAndProduct(user, product);
            if (rating != null) {
                model.addAttribute("userRating", rating.getRate());
            } else {
                model.addAttribute("userRating", 0);
            }

        }
        return "/detail";
    }

    @GetMapping("/admin/createProduct")
    public String toCreate(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @PostMapping("/admin/createProduct")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
                         @RequestParam MultipartFile imgFile) {
        productValidate.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createProduct";
        } else {
            productService.create(product, imgFile);
            return "redirect:/admin/showProducts";
        }
    }

    @GetMapping("/admin/showProducts")
    public String show(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("products", productService.getProducts(PageRequest.of(page, 4)));
        return "showProducts";
    }

    @GetMapping("/admin/editProduct")
    public String toEdit(Model model, int id) {
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/admin/editProduct")
    public String edit(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, @RequestParam MultipartFile imgFile) {
        productValidate.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editProduct";
        } else {
            productService.edit(product, imgFile);
            return "redirect:/admin/showProducts";
        }
    }

    @GetMapping("/admin/removeProduct")
    public String remove(int id) {
        productService.delete(productService.findById(id));
        return "redirect:/admin/showProducts";
    }
}
