package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.BusinessTypes;
import org.launchcode.neighborgoods.models.Categories;
import org.launchcode.neighborgoods.models.SubCategories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("browse")
public class BrowseController {

    @GetMapping
    public String displayAllBusinesses(Model model){
        model.addAttribute("categories", Categories.values());
        model.addAttribute("subcategories", SubCategories.values());

        return "browse";
    }


    @GetMapping("business")
    public String browseByCategorySubType(Model model, @RequestParam String column, @RequestParam String value){


        return "business";
    }

}
