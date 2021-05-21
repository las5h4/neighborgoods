package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.BusinessCategories;
import org.launchcode.neighborgoods.models.data.BusinessInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("businessInfo")
public class BusinessCategoriesController {

    @Autowired
    private BusinessInfoRepository businessInfoRepository;

    @GetMapping
    public String displayAllBusinesses(Model model){
        model.addAttribute("title", "All Businesses");
        model.addAttribute("categories", businessInfoRepository.findAll());
        return "businessInfo/index";
    }

    //idk if this is necessary
    @GetMapping("create")
    public String renderCreateBusinessInfoForm(Model model){
        model.addAttribute("title", "Create Business");
        model.addAttribute(new BusinessCategories());
        return "businessInfo/create";
    }

    @PostMapping("create")
    public String processCreateBusinessInfoForm(Errors errors, Model model){
        if (errors.hasErrors()){
            return "businessInfo/create";
        }
        model.addAttribute("title", "Create Business");
        model.addAttribute(new BusinessCategories());
        return "redirect:";
    }

}
