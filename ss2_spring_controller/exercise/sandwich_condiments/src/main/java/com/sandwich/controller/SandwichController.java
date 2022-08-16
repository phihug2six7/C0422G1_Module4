package com.sandwich.controller;

import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    private ISandwichService iSandwichService;

    @GetMapping("/")
    public String check(Model model) {
        model.addAttribute("list", iSandwichService.findAll());
        return "/condiments";
    }

    @GetMapping("/save")
    public String choose(@RequestParam("condiment") String[] condimentUser, Model model) {
        model.addAttribute("condimentUser", condimentUser);
        model.addAttribute("list", iSandwichService.findAll());
        return "/condiments";
    }

}
