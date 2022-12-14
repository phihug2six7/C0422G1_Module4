package com.example.controller;

import com.example.model.Contract;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/contractRest")
public class ContractRestController {
    @Autowired
    private IContractService iContractService;
    @GetMapping
    public ResponseEntity<Page<Contract>> showContract(@RequestParam(defaultValue = "")String keyword,
                                                       @PageableDefault(size = 2) Pageable pageable){
        Page<Contract> contracts=iContractService.findAll(keyword, pageable);
        if (!contracts.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts,HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Contract> viewContract(@RequestParam int id){
        Contract contract = this.iContractService.findById(id);
        if (contract == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }
}
