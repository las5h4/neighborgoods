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
        Iterable<Business> result = businessRepository.findAll();
        ArrayList<Business> businesses = new ArrayList();

       /* if(result.equals("restaurant")){
            ArrayList<Business> restaurants = new ArrayList();
            restaurants.add(result.category);
        }*/

        for (Business business : result) {
            //Object allBusinesses = business.getBusinessCategory();
            //gorl idek
            //String business1 = business.getBusinessCategory();
            //String allBusinesses = business.getBusinessCategory().toLowerCase();
            if (business.equals(category)) {

                //model.addAttribute("restaurants", result);
                //if (business.getBusinessCategory().equals(category)){
                //put business into businesses array and display
                //System.out.println(business);
            //    model.addAttribute("category");
                //businesses.add(new String(business.getBusinessName()));
                //}
                businesses.add(business);
            }



        }
        model.addAttribute("businesses", result);
        return "browse-list";

    }

}
