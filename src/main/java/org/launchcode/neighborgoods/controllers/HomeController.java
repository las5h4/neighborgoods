package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="index")
public class HomeController {
    @Autowired
    private BusinessRepository businessRepository;
    @GetMapping("")
    public String homePage(Model model){
        model.addAttribute("business",businessRepository.findByDateAdded());
        return "index";
    }
}
