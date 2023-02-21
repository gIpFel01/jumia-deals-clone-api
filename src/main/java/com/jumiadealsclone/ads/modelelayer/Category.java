package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "idcategory",nullable = false)
    private long idCategory;

    @Column(name = "labelcategory")
    private String labelCategory;

    public Category() {
    }

    public Category(long idCategory, String labelCategory) {
        this.idCategory = idCategory;
        this.labelCategory = labelCategory;
    }

    public Category(String labelCategory) {
        this.labelCategory = labelCategory;
    }

    public long idCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String labelCategory() {
        return labelCategory;
    }

    public void setLabelCategory(String labelCategory) {
        this.labelCategory = labelCategory;
    }

}
