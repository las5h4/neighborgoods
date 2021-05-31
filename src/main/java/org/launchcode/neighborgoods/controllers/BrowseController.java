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
import java.util.HashMap;

@Controller
@RequestMapping("browse")
public class BrowseController {

    @Autowired
    private BusinessRepository businessRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public BrowseController() {
        columnChoices.put("all", "All");
        columnChoices.put("restaurant", "Restaurants");
        columnChoices.put("retail", "Retail");
        columnChoices.put("other", "Other");
    }

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
        ArrayList<Business> extraArray = new ArrayList<>();

        for (Business business : businesses) {
            String businessCategory = business.getBusinessCategory();
            System.out.println(businessCategory);

            //String lowercaseBusinessCategory = businessCategory;
            //System.out.println(lowercaseBusinessCategory);

            if (businessCategory == category) {

                businessesByCategory.add(1, business);
                //businessesByCategory.add(business);

            } else {
                extraArray.add(business);
                //}
//why is this not displaying? figure out what to do with null
                //maybe try/catch, maybe else statement, idk either way it's trying to return null so that's blocking it
            }

        }model.addAttribute("businesses", businessesByCategory);
        return "browse-list";


        //model.addAttribute("restaurants", result);
        //if (business.getBusinessCategory().equals(category)){
        //System.out.println(business);
                /* if(result.equals("restaurant")){
            ArrayList<Business> restaurants = new ArrayList();
            restaurants.add(result.category);*/
    }
}
