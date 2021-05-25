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
import java.util.List;

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

        return "browse";
    }


    @GetMapping("browse/{category}")
    public String displayBusinessByCategory(Model model, @PathVariable String category) {
        Iterable<Business> result = businessRepository.findAll();
        ArrayList businesses = new ArrayList();
        //List<Business> businesses = new ArrayList<>();

        for (Business business : result) {
            if(business.getBusinessCategory().toLowerCase().equals(category)){
                businesses.add(business);
            }

        }
        model.addAttribute("businesses", businesses);
        return "browse";
    }

}