package org.launchcode.neighborgoods.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class BusinessData {

    public static ArrayList<Business> findByColumnAndValue(String column, String value, Iterable<Business> allBusinesses){

        ArrayList<Business> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return(ArrayList<Business>) allBusinesses;
        }

        if (column.equals("all")){
            return (ArrayList<Business>) allBusinesses;
        }

        for (Business business : allBusinesses){
            String aValue = getFieldValue(business, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())){
                results.add(business);
            }
        }
        return results;
    }

    //not sure if this is right but it's here
    public static String getFieldValue(Business business, String fieldName){
        String theValue;
        if(fieldName.equals("name")){
            theValue = business.getBusinessName();
        } else if (fieldName.equals("category")){
            theValue = business.getBusinessCategory().toString();
        } else {
            theValue = business.getBusinessSubCategory().toString();
        }

        return theValue;
    }

    public static ArrayList<Business> findByValue(String value, Iterable<Business> allBusinesses){
        String lower_val = value.toLowerCase();

        ArrayList<Business> results = new ArrayList<>();

        for (Business business : allBusinesses){
            if (business.getBusinessName().toLowerCase().contains(lower_val)){
                results.add(business);
            } else if (business.getBusinessCategory().toString().toLowerCase().contains(lower_val)){
                results.add(business);
            } else if (business.getBusinessSubCategory().toString().toLowerCase().contains(lower_val)){
                results.add(business);
            }
        }

        return results;

    }
}
