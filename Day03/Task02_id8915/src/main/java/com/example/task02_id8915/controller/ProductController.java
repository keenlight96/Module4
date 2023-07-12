package com.example.task02_id8915.controller;

import com.example.task02_id8915.model.Product;
import com.example.task02_id8915.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public String toIndex(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    @GetMapping("/add")
    public String toAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String toEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable int id, @ModelAttribute Product product)  {
        productService.editProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable int id) {
        productService.removeProductById(id);
        return "redirect:/product";
    }
}
