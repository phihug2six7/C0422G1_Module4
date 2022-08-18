package com.example.controller;

import com.example.model.Declaration;
import com.example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("full")
public class DeclarationController {
    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/showCreate")
    public String form(Model model) {
        model.addAttribute("year", iDeclarationService.findAllYears());
        model.addAttribute("gender", iDeclarationService.findAllGender());
        model.addAttribute("nation", iDeclarationService.findALlNation());
        model.addAttribute("information", iDeclarationService.findAllTravelInformation());
        model.addAttribute("dayStart", iDeclarationService.findAllDayStart());
        model.addAttribute("monthStart", iDeclarationService.findAllMonthStart());
        model.addAttribute("yearStart", iDeclarationService.findAllYearsStart());
        model.addAttribute("dayEnd", iDeclarationService.findAllDayEnd());
        model.addAttribute("monthEnd", iDeclarationService.findAllMonthEnd());
        model.addAttribute("yearsEnd", iDeclarationService.findAllYearsEnd());
        model.addAttribute("declaration", new Declaration());
        return "create";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Declaration> declarationList = iDeclarationService.findAll();
        model.addAttribute("declarationList", declarationList);
        return "list";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Declaration declaration) {
        iDeclarationService.create(declaration);
        return "redirect:/full/list";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        Declaration declaration = iDeclarationService.findById(id);
        model.addAttribute("year", iDeclarationService.findAllYears());
        model.addAttribute("gender", iDeclarationService.findAllGender());
        model.addAttribute("nation", iDeclarationService.findALlNation());
        model.addAttribute("information", iDeclarationService.findAllTravelInformation());
        model.addAttribute("dayStart", iDeclarationService.findAllDayStart());
        model.addAttribute("monthStart", iDeclarationService.findAllMonthStart());
        model.addAttribute("yearStart", iDeclarationService.findAllYearsStart());
        model.addAttribute("dayEnd", iDeclarationService.findAllDayEnd());
        model.addAttribute("monthEnd", iDeclarationService.findAllMonthEnd());
        model.addAttribute("yearsEnd", iDeclarationService.findAllYearsEnd());
        model.addAttribute("declaration", declaration);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Declaration declaration, @RequestParam int id) {
        iDeclarationService.update(id, declaration);
        return "redirect:/full/list";
    }
}
