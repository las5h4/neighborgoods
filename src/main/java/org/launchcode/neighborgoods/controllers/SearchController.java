package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.BusinessData;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class SearchController {

    @Autowired
    private BusinessRepository businessRepository;


    @GetMapping("search")

    public String search (Model model){
        return "search";
    }

    @GetMapping("search")
    public String displaySearchResults(Model model, @RequestParam String searchTerm){
        Iterable <Business> allBusinesses = businessRepository.findAll();

        ArrayList<Business> matchingBusinesses = BusinessData.findByValue(searchTerm, allBusinesses);

        model.addAttribute("businesses", matchingBusinesses);

        return "business/index";

    }
}
