package org.launchcode.neighborgoods.controllers;
//Handles both the map AND list.

import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class MapController {

    @Autowired
    private BusinessRepository businessRepository;

    @Value("${tomtom.apikey}")
    private String tomTomApiKey;

    @GetMapping("map")
    public String homePage(Model model) {
        model.addAttribute("apikey", tomTomApiKey);
        model.addAttribute("title", "All Businesses");
        model.addAttribute("businesses", businessRepository.findAll());
        model.addAttribute("businessLocations", businessLocations());
        return "map/home";
    }

    @GetMapping("/redirect/{id}")
    public RedirectView redirectToExternalUrl (@PathVariable int id, Model model) {

        Optional<Business> result = businessRepository.findById(id);
        Business business = result.get();
        String url = business.getWebsite();

        return new RedirectView(url);

    }

//    @RequestMapping(value="/{businessWebsite}", method = RequestMethod.GET)
//    public ModelAndView method(@PathVariable("businessWebsite") String businessWebsite) {
//        String original = businessRepository.getClass();
//        return new ModelAndView("redirect:" + original);
//    }

    //Code to hold the push the geocoded addressed to the map as pins.
    private static class Location {
        private final double[] lnglat;
        private final String description;
        public Location(double[] lnglat, String description) {
            this.lnglat = lnglat;
            this.description = description;
        }

        public double[] getLnglat() {
            return lnglat;
        }

        public String getDescription() {
            return description;
        }

    }

    private List<Location> businessLocations() {
        return List.of(
                new Location(new double[]{-89.9752, 38.7888}, "Edwardsville High School"),
                new Location(new double[]{-90.1848, 38.6247}, "The Gateway Arch")
        );
    }

}