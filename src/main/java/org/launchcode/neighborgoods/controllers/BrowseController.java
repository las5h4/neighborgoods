
package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.enums.Categories;
import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String browse(Model model){
        model.addAttribute("businesses", businessRepository.findAll());
        model.addAttribute("categories", Categories.values());

        return "browse";
    }

    @RequestMapping("browse")
    public String browseByCategoryType(Model model, @RequestParam String column, @RequestParam String value){
        Iterable<Business> businesses;
        if(column.toLowerCase().equals("all")){
            businesses = businessRepository.findAll();
            model.addAttribute("title", "All Businesses");
        } else {
            businesses = businessRepository.findAll();
            model.addAttribute("title", columnChoices.get(column) + ":" + value);
        } model.addAttribute("businesses", businesses);

        return "business";
    }


  /*  @GetMapping
    public String displayAllBusinesses(Model model){
        model.addAttribute("categories", Categories.values());
        model.addAttribute("subcategories", SubCategories.values());

        return "browse";
    }*/


}

