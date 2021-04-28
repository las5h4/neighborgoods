package org.launchcode.neighborgoods.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "browse")
public class BrowseController {

    static HashMap<String, String> categoryType = new HashMap<>();
    //static HashMap<String, String> categorySubType = new HashMap<>();

    public BrowseController(){
        categoryType.put("all", "All");
        categoryType.put("restaurants", "Restaurants");
        categoryType.put("retail", "Retail");
        categoryType.put("home repair", "Home Repair");
        categoryType.put("salons", "Salons");

        //categorySubType.put(*maybe input from database/file*);
    }

    public String browse(Model model){
       // model.addAttribute("rows", categoryType);

        return "browse";
    }

}
