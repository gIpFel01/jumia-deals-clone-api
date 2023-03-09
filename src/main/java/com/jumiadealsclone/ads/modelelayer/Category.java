package com.jumiadealsclone.ads.modelelayer;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @Column(name = "idcategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorytype")
    private CategoryType categoryType;

    public long idCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public CategoryType categoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", categoryType=" + categoryType +
                '}';
    }
}
