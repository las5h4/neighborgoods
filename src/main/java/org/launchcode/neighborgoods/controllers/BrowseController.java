package org.launchcode.neighborgoods.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "browse")
public class BrowseController {

    static HashMap<String, String> categoryType = new HashMap<>();
    static HashMap<String, String> categorySubType = new HashMap<>();

    public BrowseController(){
        categoryType.put("all", "All");
        categoryType.put("restaurants", "Restaurants");
        categoryType.put("retail", "Retail");
        categoryType.put("home repair", "Home Repair");
        categoryType.put("salons", "Salons");

        categorySubType.put("breakfast", "Breakfast");
        categorySubType.put("coffee", "Coffee/Tea");

    }

    @RequestMapping(value="")
    public String browse(Model model){
       // model.addAttribute("rows", categoryType);
        //fill in once data is figured out

        return "browse";
    }

//    @RequestMapping(value="")
//    public String browseByCategorySubType(Model model){
//        //this part will render a different view based on which subcategory the user clicks
//        //this part depends on where data is being pulled from
//
//        return "";
//    }

}
