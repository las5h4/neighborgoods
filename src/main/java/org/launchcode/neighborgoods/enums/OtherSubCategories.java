package org.launchcode.neighborgoods.enums;

public enum OtherSubCategories {

    OTHER("Other");

    private String otherSubCategoryName;

    OtherSubCategories(String otherSubCategoryName) {
        this.otherSubCategoryName = otherSubCategoryName;
    }

    public String getOtherSubCategoryName() {
        return otherSubCategoryName;
    }
}
