package org.launchcode.neighborgoods.enums;

public enum RestaurantSubCategories {

    BREAKFAST("Breakfast"),
    DINNER("Dinner"),
    CAFE("Cafe"),
    COFFEE_TEA("Coffee/Tea"),
    DESSERT("Dessert"),
    BARS("Bars");


    private String restaurantSubCategoryName;

    RestaurantSubCategories(String restaurantSubCategoryName) {
        this.restaurantSubCategoryName = restaurantSubCategoryName;
    }

    public String getRestaurantSubCategoryName() {
        return restaurantSubCategoryName;
    }
}
