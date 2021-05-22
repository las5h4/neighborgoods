package org.launchcode.neighborgoods.controllers;

import jdk.jfr.Category;
import org.launchcode.neighborgoods.enums.Categories;
import org.launchcode.neighborgoods.enums.SubCategories;
import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.BusinessData;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ManyToMany;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("browse")
public class BrowseController {

    @Autowired
    private BusinessRepository businessRepository;

    //not sure if this is necessary
  //  private Business business;

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


    @RequestMapping(value = "business")
    public String displayBusinessByCategory(Model model, @RequestParam String column, @RequestParam String value,
                                            @PathVariable Integer id) {
        Iterable<Business> result = businessRepository.findAll();
       // Business business = result.get();
        Business[] allBusinesses = new Business[0];

        for (Business item : allBusinesses) {
            if (column.toLowerCase().equals("all")) {
                result = businessRepository.findAll();
                model.addAttribute("title", "View All");
            }
           // model.addAttribute("title", columnChoices.get(column) + ": " + value);
        }
        return "business";
    }
}


/*if(column.toLowerCase().equals("all")){
                businesses = businessRepository.findAll();
                model.addAttribute("title", "All Businesses");
            } else {

            }
            return "";
        }*/

// Categories<business> result = businessRepository.findAll();

//businesses = BusinessData.findByColumnAndValue(column, value, businessRepository.findAll());
//businessRepository.findbycolumnandvalue
//model.addAttribute("title", "Businesses with " + columnChoices.get(column) + ": " + value);
//}