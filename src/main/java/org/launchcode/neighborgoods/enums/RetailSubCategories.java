package org.launchcode.neighborgoods.enums;

public enum RetailSubCategories {

    CLOTHING("Clothing Store"),
    HOME_GOODS("Home Goods"),
    GIFTS("Gifts"),
    PLANTS("Plant Shops");

    private String retailSubCategoryName;

    RetailSubCategories(String retailSubCategoryName) {
        this.retailSubCategoryName = retailSubCategoryName;
    }

    public String getRetailSubCategoryName() {
        return retailSubCategoryName;
    }
}
