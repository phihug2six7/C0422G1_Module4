package com.example.controller;

import com.example.model.Email;
import com.example.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LanguageController {
    @Autowired
    private ILanguageService iLanguageService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("listLanguage", iLanguageService.findAllLanguage());
        model.addAttribute("listSizePage", iLanguageService.findAllPageSize());
        model.addAttribute("email", new Email());
        return "settings";
    }

    @PostMapping("/details")
    public String update(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("email", email);
        return "save";
    }
}
