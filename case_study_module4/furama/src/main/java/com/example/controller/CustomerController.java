package com.example.controller;

import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/customer/list")
    public String showList(Model model, @PageableDefault(size = 4) Pageable pageable){
        model.addAttribute("customerList",iCustomerService.findAll(pageable));
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String create(@ModelAttribute Customer customer,Model model){
        CustomerType customerType=new CustomerType();
        customerType.setId(customer.getCustomerType().getId());
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/customer/update")
    public String showUpdate(@RequestParam int id,Model model){
        model.addAttribute("customerList",iCustomerService.findById(id));
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/update";
    }
    @PostMapping("/customer/update")
    public String update(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/customer/delete")
    public String delete(@RequestParam Integer id){
        iCustomerService.remove(id);
        return "redirect:/customer/list";
    }
}
