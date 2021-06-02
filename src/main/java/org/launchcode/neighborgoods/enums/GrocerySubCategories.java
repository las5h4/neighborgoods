package org.launchcode.neighborgoods.enums;

public enum GrocerySubCategories {

    GROCERY("Grocery"),
    GAS_STATION("Gas Station"),
    CONVENIENCE_STORE("Convenience Store");

    private String grocerySubCategoryName;

    GrocerySubCategories(String grocerySubCategoryName) {
        this.grocerySubCategoryName = grocerySubCategoryName;
    }

    public String getGrocerySubCategoryName() {
        return grocerySubCategoryName;
    }
}
