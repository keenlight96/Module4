package com.example.task04.controller;

import com.example.task04.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/translate")
    public String getVietnamese(String word, Model model) {
        model.addAttribute("vnWord", dictionaryService.getVietnamese(word));
        return "/result";
    }
}
