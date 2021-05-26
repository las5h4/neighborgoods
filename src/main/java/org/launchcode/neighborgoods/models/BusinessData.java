package org.launchcode.neighborgoods.models;

import java.util.ArrayList;
import java.util.Locale;

public class BusinessData {

    public static ArrayList<Business> findByValue(String searchTerm, Iterable<Business> allBusinesses){
        String lower_val = searchTerm.toLowerCase();

        ArrayList<Business> results = new ArrayList<>();

        for (Business business : allBusinesses) {
            if (business.getBusinessName().toLowerCase().contains(lower_val)){
                results.add(business);
            } else if (business.getCity().toLowerCase().contains(lower_val)){
                results.add(business);
            } else if (business.getState().toLowerCase().contains(lower_val)) {
                results.add(business);
            } else if (business.getZipCode().toLowerCase().contains(lower_val)) {
                results.add(business);
            } else if (business.getOwnerName().toLowerCase().contains(lower_val)) {
                results.add(business);
            } else if (business.getBusinessCategory().toLowerCase().contains(lower_val)) {
                results.add(business);
            } else if (business.getBusinessSubCategory().toLowerCase().contains(lower_val)) {
                results.add(business);
            }
        }

        return results;
    }
}
