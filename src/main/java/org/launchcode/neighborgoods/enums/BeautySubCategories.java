package org.launchcode.neighborgoods.enums;

public enum BeautySubCategories {

    HAIR_SALON("Hair Salon"),
    NAIL_SALON("Nail Salon"),
    SPA("Spa");

    private String beautySubCategoryName;

    BeautySubCategories(String beautySubCategoryName) {
        this.beautySubCategoryName = beautySubCategoryName;
    }

    public String getBeautySubCategoryName() {
        return beautySubCategoryName;
    }
}
