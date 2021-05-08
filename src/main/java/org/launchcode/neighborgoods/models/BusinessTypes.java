package org.launchcode.neighborgoods.models;

public class BusinessTypes {

    private org.launchcode.neighborgoods.models.Categories categories;
    private org.launchcode.neighborgoods.models.SubCategories subCategories;

    public BusinessTypes(org.launchcode.neighborgoods.models.Categories categories, org.launchcode.neighborgoods.models.SubCategories subCategories){
        this.categories = categories;
        this.subCategories = subCategories;
    }

    public org.launchcode.neighborgoods.models.Categories getCategories() {
        return categories;
    }

    public void setCategories(org.launchcode.neighborgoods.models.Categories categories) {
        this.categories = categories;
    }

    public org.launchcode.neighborgoods.models.SubCategories getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(org.launchcode.neighborgoods.models.SubCategories subCategories) {
        this.subCategories = subCategories;
    }

}
