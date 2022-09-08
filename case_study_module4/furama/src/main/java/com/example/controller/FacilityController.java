package com.example.controller;

import com.example.model.Facility;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IRentTypeService;
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
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/facility/list")
    public String showList(@RequestParam(defaultValue = "") String keyword,
                           @PageableDefault(size = 2) Pageable pageable,
                           Model model) {
        model.addAttribute("keyword",keyword);
        model.addAttribute("facilityList", iFacilityService.findAllFacility(keyword, pageable));
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("rentType",iRentTypeService.findAllRentType());
        return "facility/list";
    }

    @GetMapping("/facility/create")
    public String showCreate(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("rentTypeList",iRentTypeService.findAllRentType());
        return "/facility/create";
    }
    @PostMapping("/facility/create")
    public String create(@ModelAttribute Facility facility){
        iFacilityService.saveFacility(facility);
        return "redirect:/facility/list";
    }
    @GetMapping("/facility/update")
    public String showUpdate(@RequestParam Integer id,Model model){
        model.addAttribute("facility",iFacilityService.findByIdFacility(id));
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("rentTypeList",iRentTypeService.findAllRentType());
        return "facility/update";
    }
    @PostMapping("/facility/update")
    public String update(@ModelAttribute Facility facility){
        iFacilityService.saveFacility(facility);
        return "redirect:/facility/list";
    }
    @GetMapping("/facility/delete")
    public String delete(@RequestParam Integer id){
        iFacilityService.removeFacility(id);
        return "redirect:/facility/list";
    }
}
