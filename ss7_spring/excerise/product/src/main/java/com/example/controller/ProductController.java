package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showList(Model model,
                           @PageableDefault(size = 2)Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("productList", iProductService.findAll(keywordVal,pageable));
        model.addAttribute("keywordVal",keywordVal);
        return "list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/list";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        iProductService.update(product);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete( int id) {
        iProductService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/showView")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/detail";
    }
}
