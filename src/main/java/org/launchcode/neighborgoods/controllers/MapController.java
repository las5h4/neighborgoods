package org.launchcode.neighborgoods.controllers;
//Handles both the map AND list.

import org.json.*;
import com.mysql.cj.xdevapi.JsonArray;
import org.launchcode.neighborgoods.models.Business;
import org.launchcode.neighborgoods.models.data.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.reflect.Array;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MapController {

    @Autowired
    private BusinessRepository businessRepository;

    @Value("${tomtom.apikey}")
    private String tomTomApiKey;

    public ArrayList<ArrayList<String>> locationData = new ArrayList<>();

    @GetMapping("map")
    public String homePage(Model model) {

            ArrayList<Business> businesses = new ArrayList<>();
            businessRepository.findAll().forEach(businesses::add);

            for (Business business : businesses) {
                String formattedAddress = business.getStreetAddress() + "%20" + business.getCity() + "%20" + business.getState();
                formattedAddress = formattedAddress.replaceAll("\\s+","%20");
                RestTemplate restTemplate = new RestTemplate();
                String fooResourceUrl
                        = "https://maps.googleapis.com/maps/api/geocode/json";
                ResponseEntity<String> response
                        = restTemplate.getForEntity(fooResourceUrl + "?address=" + formattedAddress + "&key=AIzaSyALRi5gBbuIKhx2nnLh-z5f5OcOinK4-Xw", String.class);

                JSONObject responseJSON = new JSONObject(response);
                JSONObject body = new JSONObject(responseJSON.getString("body"));
                JSONArray results = new JSONArray(body.getJSONArray("results"));
                JSONObject resultsOpt = results.optJSONObject(0);
                JSONObject geometry = resultsOpt.getJSONObject("geometry");
                JSONObject location = geometry.getJSONObject("location");

                ArrayList<String> lngLat = new ArrayList<>();
                String lngString = Double.toString(location.getDouble("lng"));
                String latString = Double.toString(location.getDouble("lat"));
                lngLat.add(lngString);
                lngLat.add(latString);
                lngLat.add(business.getBusinessName());

                locationData.add(lngLat);
            }

          System.out.println(locationData);

        model.addAttribute("apikey", tomTomApiKey);
        model.addAttribute("title", "All Businesses");
        model.addAttribute("businesses", businessRepository.findAll());
        model.addAttribute("businessLocations", businessLocations());

        return "map/home";
    }

    @GetMapping("/redirect/{id}")
    public String redirectToExternalUrl (@PathVariable int id, Model model) {

        Optional<Business> result = businessRepository.findById(id);
        Business business = result.get();
        String url = business.getWebsite();

        if(!url.matches("^(https?|ftp)://.*$")){
            url = "https://" + url;
        }

        return "redirect:" + url;

    }

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

        List<Location> Locations = new ArrayList<>();

        for(int i = 0; i < locationData.size(); i++){
            Location location = new Location(new double[]{Double.parseDouble(locationData.get(i).get(0)), Double.parseDouble(locationData.get(i).get(1))}, locationData.get(i).get(2));
            Locations.add(location);
        }

        return Locations;

    }

}