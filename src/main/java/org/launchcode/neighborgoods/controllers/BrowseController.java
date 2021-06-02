package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("browse")
public class BrowseController {

    @Autowired
    private BusinessRepository businessRepository;

    @RequestMapping
    public String browse(Model model) {
        model.addAttribute("businesses", businessRepository.findAll());
        model.addAttribute("categories");

        return "browse";
    }

    @GetMapping("{category}")
    public String displayBusinessByCategory(Model model, @PathVariable String category) {
        ArrayList<Business> businesses = new ArrayList<>();
        businessRepository.findAll().forEach(businesses::add);
        ArrayList<Business> businessesByCategory = new ArrayList<>();
        ArrayList<Business> noCategory = new ArrayList<>();

        for (Business business : businesses) {
            String businessCategory = business.getBusinessCategory();
            if (businessCategory.contains(category)) {
                businessesByCategory.add(business);
            }
        }
        model.addAttribute("businesses", businessesByCategory);
        return "browse-list";
    }

}
