package org.launchcode.neighborgoods.enums;

public enum AutoServicesSubCategories {

    CAR_WASH("Car Wash"),
    AUTO_REPAIR("Auto Repair");

    private String autoSubCategoryName;

    AutoServicesSubCategories(String subCategoryName) {
        this.autoSubCategoryName = autoSubCategoryName;
    }

    public String getAutoSubCategoryName() {
        return autoSubCategoryName;
    }

}
