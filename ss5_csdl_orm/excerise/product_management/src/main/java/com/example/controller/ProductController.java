package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("full")
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public String showList(Model model, String nameSearch) {
        List<Product> productList = iProductService.findAll(nameSearch);
        model.addAttribute("productList", productList);
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
        return "redirect:/full/list";
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
        return "redirect:/full/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iProductService.delete(id);
        return "redirect:/full/list";
    }

    @GetMapping("/showView")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/detail";
    }
}
