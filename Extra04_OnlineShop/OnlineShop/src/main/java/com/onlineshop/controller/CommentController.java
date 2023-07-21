package com.onlineshop.controller;

import com.onlineshop.model.Comment;
import com.onlineshop.model.Product;
import com.onlineshop.model.User;
import com.onlineshop.repository.ICommentRepository;
import com.onlineshop.service.CommentService;
import com.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    HttpSession session;
    @Autowired
    CommentService commentService;
    @Autowired
    ProductService productService;

    @PostMapping("/user/comment")
    public String comment(@RequestParam("productId") int productId, String content, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("currentUser");
        Product product = productService.findById(productId);
        Comment comment = new Comment(0, user, product, content);
        commentService.save(comment);
        redirectAttributes.addAttribute("id",productId);
        return "redirect:/product/detail";
    }
}
