package com.bai_tap1.controller;

import com.bai_tap1.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Currency {
    @Autowired
    ICurrencyService iCurrencyService;

    @GetMapping("/")
    public String convert() {
        return "/currency";
    }

    @GetMapping("/convert")
    public String currencyConvert(@RequestParam float usd, Model model) {
        float vnd = iCurrencyService.convert(usd);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "/currency";
    }
}
