package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("business")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    @GetMapping
    public String displayBusinesses(Model model){
        model.addAttribute("title", "All Businesses");
        model.addAttribute("business", businessRepository.findAll());
        return "business/index";
    }

    @GetMapping("add")
    public String displayAddBusinessForm(Model model){
        model.addAttribute(new Business());
        return "business/add";
    }

    @PostMapping("add")
    public String processAddBusinessForm(@ModelAttribute @Valid Business newBusiness, Errors errors, Model model){
       if (errors.hasErrors()){
           return "business/add";
       }

       businessRepository.save(newBusiness);
       return "redirect:";
    }

    @GetMapping("view/{businessId}")
    public String displayViewBusiness(Model model, @PathVariable int businessId){
        Optional<Business> optBusiness = businessRepository.findById(businessId);
        if (optBusiness.isPresent()){
            Business business = (Business) optBusiness.get();
            model.addAttribute("business", business);
            return "business/view";
        } else {
            return "redirect:";
        }
    }
}
