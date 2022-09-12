package com.example.controller;

import com.example.service.IContractDetailService;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;
    @GetMapping("/contract/list")
    public String showList(@RequestParam(defaultValue = "") String keyword
            , @PageableDefault(size = 2) Pageable pageable,
                           Model model) {
        model.addAttribute("keyword",keyword);
        model.addAttribute("contractList", iContractService.findAll(keyword, pageable));
        model.addAttribute("contractDetail", iContractDetailService.findAll());
        return "contract/list";
    }
}
