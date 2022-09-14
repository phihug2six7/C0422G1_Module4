package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/customer/list")
    public String showList(@RequestParam(defaultValue = "") String keyword
            , @PageableDefault(size = 2) Pageable pageable,
                           Model model) {
        model.addAttribute("keyword",keyword);
        model.addAttribute("customerList", iCustomerService.findAll(keyword, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String create(@ModelAttribute @Valid CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/create";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);

//        CustomerType customerType = new CustomerType();
//        customerType.setId(customerDto.getCustomerType().getId());
//        customer.setCustomerType(customerType);

        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Register successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/update")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("customerList", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "customer/update";
    }

    @PostMapping("/customer/update")
    public String update(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Update successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/delete")
    public String delete(@RequestParam Integer customerIdDelete,RedirectAttributes redirectAttributes) {
        iCustomerService.remove(customerIdDelete);
        redirectAttributes.addFlashAttribute("msg","Delete successfully!");
        return "redirect:/customer/list";
    }
}
