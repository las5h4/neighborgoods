package org.launchcode.neighborgoods.enums;

public enum Categories {

    RESTAURANTS("restaurant"),
    RETAIL ("retail"),
    GROCERY("grocery"),
    BEAUTY("beauty"),
    HOME_SERVICES("home"),
    AUTO_SERVICES("auto"),
    OTHER("other");

    private String categoryName;

    Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
