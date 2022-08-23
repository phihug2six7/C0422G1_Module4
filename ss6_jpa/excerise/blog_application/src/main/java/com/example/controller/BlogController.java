package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("fullList", iBlogService.findAll());
        return "/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("form", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công ");
        return "redirect:/";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog_update", blog);
        return "update";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.create(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        iBlogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "detail";
    }
}
