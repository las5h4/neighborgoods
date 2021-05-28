package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.BusinessCategories;
import org.launchcode.neighborgoods.models.BusinessData;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("browse")
public class BrowseController {

    @Autowired
    private BusinessRepository businessRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public BrowseController(){
        columnChoices.put("all", "All");
        columnChoices.put("restaurant", "Restaurants");
        columnChoices.put("retail", "Retail");
        columnChoices.put("other", "Other");
    }

    @RequestMapping
    public String browse(Model model) {
        model.addAttribute("businesses", businessRepository.findAll());
        model.addAttribute("categories");
//add hashmap? somehow getbusinessCategories?
        return "browse";
    }


    @GetMapping("{category}")
    public String displayBusinessByCategory(Model model, @PathVariable String category) {
        ArrayList<Business> businesses = new ArrayList<>();

        businessRepository.findAll().forEach(businesses::add);
        ArrayList<Business> businessesByCategory = new ArrayList<>();

        for (Business business : businesses) {
            String businessCategory = business.getBusinessCategory();
            System.out.println(businessCategory);
            System.out.println(businessCategory.getClass().getSimpleName());
            String lowercaseBusinessCategory = businessCategory.toLowerCase();
            System.out.println(lowercaseBusinessCategory);
            System.out.println(lowercaseBusinessCategory.getClass().getSimpleName());
            if (lowercaseBusinessCategory == category) {

                businessesByCategory.add(business);

            } else {
                model.addAttribute("null", null);
            }

        }
        model.addAttribute("businesses", businessesByCategory);
        return "browse-list";

    }

    //model.addAttribute("restaurants", result);
    //if (business.getBusinessCategory().equals(category)){
    //System.out.println(business);
                /* if(result.equals("restaurant")){
            ArrayList<Business> restaurants = new ArrayList();
            restaurants.add(result.category);
        }*/

}
