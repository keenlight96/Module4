package com.myblog.controller;

import com.myblog.model.Post;
import com.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    PostService postService;
    @GetMapping("/home")
    public String toHomePage(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "/home";
    }

    @GetMapping("/post")
    public String toPost(int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "/post";
    }

    @GetMapping("/edit")
    public String toEdit(int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "/edit-post";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post) {
        postService.editPost(post);
        return "redirect:/post?id=" + post.getId();
    }

    @GetMapping("/create")
    public String toCreate() {
        return "/create-post";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Post post) {
        int id = postService.createPost(post);
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/delete")
    public String delete(int id) {
        postService.deletePost(id);
        return "redirect:/home";
    }
}
