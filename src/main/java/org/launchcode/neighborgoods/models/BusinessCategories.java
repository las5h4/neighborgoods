package org.launchcode.neighborgoods.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BusinessCategories {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private Business business;

    public BusinessCategories(String name){
        this.name = name;
    }

    public BusinessCategories() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
