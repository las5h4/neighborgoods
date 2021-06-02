package org.launchcode.neighborgoods.enums;

public enum HomeServicesSubCategories {

    PLUMBER("Plumber"),
    ELECTRICIAN("Electrician"),
    HOME_CLEANERS("Home Cleaners");

    private String homeSubCategoryName;

    HomeServicesSubCategories(String homeSubCategoryName) {
        this.homeSubCategoryName = homeSubCategoryName;
    }

    public String getHomeSubCategoryName() {
        return homeSubCategoryName;
    }
}
