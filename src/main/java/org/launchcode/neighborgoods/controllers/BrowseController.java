package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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


    @GetMapping("browse/{category}")
    public String displayBusinessByCategory(Model model, @PathVariable String category) {
        Iterable<Business> result = businessRepository.findAll();
        //arraylist? list?
        List businesses = new ArrayList<>();

        for (Business business : result) {
            if (business.getBusinessCategory().toLowerCase().equals(category)) {
                businesses.add(business);
                //businesses.push(business);
            }
        }
        model.addAttribute("businesses", businesses);
        return "browse";
    }

   /* @GetMapping("view")
    public String displayCategories(Model model, @PathVariable int id) {

        Optional optCategory = businessRepository.findById(id);
        if (optCategory.isPresent()) {
            Business business = (Business) optCategory.get();
            model.addAttribute("businesses", business);
            return "business/view";
        } else {
            return "redirect:../";
        }
    }*/
}

// Categories<business> result = businessRepository.findAll();

//businesses = BusinessData.findByColumnAndValue(column, value, businessRepository.findAll());
//businessRepository.findbycolumnandvalue
//model.addAttribute("title", "Businesses with " + columnChoices.get(column) + ": " + value);
//}