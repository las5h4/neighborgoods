package org.launchcode.neighborgoods.models;

public enum Categories {

    RESTAURANTS("Restaurants"),
    RETAIL ("Retail"),
    GROCERY("Grocery"),
    BEAUTY("Beauty"),
    HOME_SERVICES("Home Services"),
    AUTO_SERVICES("Auto Services"),
    OTHER("Other");

    private String categoryName;

    Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
