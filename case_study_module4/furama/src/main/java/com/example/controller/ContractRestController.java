package com.example.controller;

import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class ContractRestController {
    @Autowired
    private IContractService iContractService;
}
