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
    GAS_STATION("gas station"),
    HAIR_SALON("hair salon"),
    NAIL_SALON("nail salon"),
    SPA("spa"),
    PLUMBER("plumber"),
    ELECTRICIAN("electrician"),
    HOME_CLEANERS("home cleaners"),
    CAR_WASH("car wash"),
    AUTO_REPAIR("auto repair"),
    OTHER("other");

    private String subCategoryName;

    SubCategories(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }
}
