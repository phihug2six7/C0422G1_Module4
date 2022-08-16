package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String convert() {
        return "/dictionary";
    }

    @PostMapping("/convert")
    public String dictionaryConvert(@RequestParam String word, Model model) {
        String result = iDictionaryService.convert(word);
        model.addAttribute("result", result);
        return "/dictionary";
    }
}
