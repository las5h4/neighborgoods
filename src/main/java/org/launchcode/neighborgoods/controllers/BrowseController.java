package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("browse")
public class BrowseController {

    @Autowired
    private BusinessRepository businessRepository;


    @RequestMapping
    public String browse(Model model) {
        model.addAttribute("businesses", businessRepository.findAll());

        return "browse";
    }

    /*@GetMapping("{name}")
    @ResponseBody
    public String browseByName(@PathVariable String name){
        return "Hello" + name + "!";
    }*/

    @GetMapping("{category}")
    public String displayBusinessByCategory(Model model, @PathVariable String category) {
        Iterable<Business> result = businessRepository.findAll();
        ArrayList<Business> businesses = new ArrayList();

        for (Business business : result) {
            if(business.getBusinessCategory().toLowerCase().equals(category)){
                businesses.add(business);
            }

        }
        model.addAttribute("businesses", businesses);
        return "browse";
    }

}