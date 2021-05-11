package org.launchcode.neighborgoods.models;

import org.launchcode.neighborgoods.enums.*;

public class BusinessTypes {

    private Categories categories;
    private AutoServicesSubCategories autoServicesSubCategories;
    private BeautySubCategories beautySubCategories;
    private GrocerySubCategories grocerySubCategories;
    private HomeServicesSubCategories homeServicesSubCategories;
    private OtherSubCategories otherSubCategories;
    private RestaurantSubCategories restaurantSubCategories;
    private RetailSubCategories retailSubCategories;
    private SubCategories subCategories;

    public BusinessTypes(Categories categories, SubCategories subCategories){
        this.categories = categories;
        this.subCategories = subCategories;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public AutoServicesSubCategories getAutoServicesSubCategories() {
        return autoServicesSubCategories;
    }

    public void setAutoServicesSubCategories(AutoServicesSubCategories autoServicesSubCategories) {
        this.autoServicesSubCategories = autoServicesSubCategories;
    }

    public BeautySubCategories getBeautySubCategories() {
        return beautySubCategories;
    }

    public void setBeautySubCategories(BeautySubCategories beautySubCategories) {
        this.beautySubCategories = beautySubCategories;
    }

    public GrocerySubCategories getGrocerySubCategories() {
        return grocerySubCategories;
    }

    public void setGrocerySubCategories(GrocerySubCategories grocerySubCategories) {
        this.grocerySubCategories = grocerySubCategories;
    }

    public HomeServicesSubCategories getHomeServicesSubCategories() {
        return homeServicesSubCategories;
    }

    public void setHomeServicesSubCategories(HomeServicesSubCategories homeServicesSubCategories) {
        this.homeServicesSubCategories = homeServicesSubCategories;
    }

    public OtherSubCategories getOtherSubCategories() {
        return otherSubCategories;
    }

    public void setOtherSubCategories(OtherSubCategories otherSubCategories) {
        this.otherSubCategories = otherSubCategories;
    }

    public RestaurantSubCategories getRestaurantSubCategories() {
        return restaurantSubCategories;
    }

    public void setRestaurantSubCategories(RestaurantSubCategories restaurantSubCategories) {
        this.restaurantSubCategories = restaurantSubCategories;
    }

    public RetailSubCategories getRetailSubCategories() {
        return retailSubCategories;
    }

    public void setRetailSubCategories(RetailSubCategories retailSubCategories) {
        this.retailSubCategories = retailSubCategories;
    }

    public SubCategories getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(SubCategories subCategories) {
        this.subCategories = subCategories;
    }

}
