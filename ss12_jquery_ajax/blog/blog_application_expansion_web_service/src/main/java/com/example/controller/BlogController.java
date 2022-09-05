package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String showList(Model model,
                           @PageableDefault(size = 2) Pageable pageable,
                           @RequestParam Optional<String> keyword, Blog blog) {

        String keywordVal = keyword.orElse("");
        String keywordtest = "";


        if (blog.getCategory() != null) {
            model.addAttribute("fullList", iBlogService.findAllByNameContainingAndCategory_CId(keywordtest, blog.getCategory().getcId(), pageable));
        } else {
            model.addAttribute("fullList",
                    iBlogService.findAllSearchAndPaging(keywordVal, pageable));
        }
        model.addAttribute("categoryList", iCategoryService.findAllCate(pageable));
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("blog", blog);
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
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công ");
        return "redirect:/";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog_update", blog);
        return "update";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "detail";
    }
}
