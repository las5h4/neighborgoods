package org.launchcode.neighborgoods.enums;

public enum OwnerTag {

    MINORITY_OWNED("Minority-owned"),
    BLACK_OWNED("Black-owned"),
    IMMIGRANT_OWNED("Immigrant-owned"),
    WOMAN_OWNED("Woman-owned"),
    DISABILITY_OWNED("Disability-owned"),
    LGBTQ_OWNED("LGBTQ-owned"),
    VETERAN_OWNED("Veteran-owned"),
    OTHER("Other"),
    NONE("None");

    private String tagName;

    OwnerTag(String tagName){this.tagName = tagName;}

    public String getTagName() {
        return tagName;
    }
}
