package org.launchcode.neighborgoods.enums;

public enum SubCategories {

    BREAKFAST("Breakfast"),
    DINNER("Dinner"),
    CAFE("Cafe"),
    COFFEE_TEA("Coffee/Tea"),
    DESSERT("Dessert"),
    BARS("Bars"),
    CLOTHING("Clothing Store"),
    HOME_GOODS("Home Goods"),
    GIFTS("Gifts"),
    GROCERY("Grocery"),
    GAS_STATION("Gas Station"),
    CONVENIENCE_STORE("Convenience Store"),
    HAIR_SALON("Hair Salon"),
    NAIL_SALON("Nail Salon"),
    SPA("Spa"),
    PLUMBER("Plumber"),
    ELECTRICIAN("Electrician"),
    HOME_CLEANERS("Home Cleaners"),
    CAR_WASH("Car Wash"),
    AUTO_REPAIR("Auto Repair");

    private String subCategoryName;

    SubCategories(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }
}
