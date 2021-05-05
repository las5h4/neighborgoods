package org.launchcode.neighborgoods.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private int zipCode;

    private String phoneNumber;

    private String website;

    private String ownerName;

    private String email;

    private String ownerType;

    private String businessCategory;

    private String businessSubCategory;

    public Business () {};
    public Business (String businessName, String streetAddress, String city, String state, int zipCode,
                     String phoneNumber, String website, String ownerName, String email, String ownerType,
                     String businessCategory, String businessSubCategory){
        this.businessName = businessName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.ownerName = ownerName;
        this.email = email;
        this.ownerType = ownerType;
        this.businessCategory = businessCategory;
        this.businessSubCategory = businessSubCategory;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
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

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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
