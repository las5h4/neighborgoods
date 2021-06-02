package org.launchcode.neighborgoods.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;

@Entity
public class Business {

    @Id
    @GeneratedValue
    private int id;

    private String dateAdded;

    private String businessName;

    private String streetAddress;

    private String city;

    private String state;

    private String zipCode;

    private String phoneNumber;

    private String website;

    private String ownerName;

    private String email;

    private String businessTag;

    private String businessCategory;

    private String businessSubCategory;

    private boolean onlineShopping;

    public Business () {};
    public Business (String businessName, String streetAddress, String city, String state, String zipCode,
                     String phoneNumber, String website, String ownerName, String email, String businessTag,
                     String businessCategory, String businessSubCategory, boolean onlineShopping){
        this.businessName = businessName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.ownerName = ownerName;
        this.email = email;
        this.businessTag = businessTag;
        this.businessCategory = businessCategory;
        this.businessSubCategory = businessSubCategory;
        this.onlineShopping = onlineShopping;
    }

    public int getId() {
        return id;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessTag() {
        return businessTag;
    }

    public void setOwnerType(String businessTag) {
        this.businessTag = businessTag;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessSubCategory() {
        return businessSubCategory;
    }

    public void setBusinessSubCategory(String businessSubCategory) {
        this.businessSubCategory = businessSubCategory;
    }

    public boolean getOnlineShopping() { return onlineShopping; }

    public void setOnlineShopping(boolean onlineShopping) { this.onlineShopping = onlineShopping; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Business)) return false;
        Business business = (Business) o;
        return businessName.equals(business.businessName) && Objects.equals(streetAddress, business.streetAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessName, streetAddress);
    }
}
