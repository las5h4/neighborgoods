package org.launchcode.neighborgoods.controllers;

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
    public String displayBusinessByCategory(Model model, @RequestParam String column,
                                            @RequestParam String value, Iterable<Integer> id) {
        Iterable<Business> result = businessRepository.findAll();
       // Business business = result.get();
        Business[] allBusinesses = new Business[0];

        for (Business item : allBusinesses) {
            if (column.toLowerCase().equals("all")) {
                result = businessRepository.findAll();
                model.addAttribute("title", "View All");
            } else if (column.toLowerCase().equals("Restaurant")) {
                result = businessRepository.findAllById(id);
                model.addAttribute("title", columnChoices.get(column) + ": " + value);
            }

        }
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