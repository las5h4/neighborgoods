package org.launchcode.neighborgoods.enums;

public enum SubCategories {

    BREAKFAST("breakfast"),
    DINNER("dinner"),
    CAFE("cafe"),
    COFFEE("coffee"),
    DESSERT("dessert"),
    BARS("bars"),
    CLOTHING("clothing"),
    GIFTS("gifts"),
    GROCERY("grocery"),
    GAS_STATION("gas"),
    PLUMBER("plumber"),
    ELECTRICIAN("electrician"),
    HOME_CLEANERS("cleaners");

    private String subCategoryName;

    SubCategories(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }
}
