package com.caculator.controller;

import com.caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController  {
    @Autowired
    ICalculatorService iCalculatorService;
    @GetMapping("/")
    public String home(Model model){
        return "result";
    }
    @GetMapping("/transfer")
    public String operator(@RequestParam String number1,String number2,String count,Model model){
        String total=iCalculatorService.choose(number1,number2,count);
        model.addAttribute("total",total);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("count",count);
        return "result";
    }
}
