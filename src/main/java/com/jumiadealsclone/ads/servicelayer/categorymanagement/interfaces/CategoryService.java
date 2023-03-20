package com.jumiadealsclone.ads.servicelayer.categorymanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.CategoryType;

import java.util.List;

public interface CategoryService {
    Category findCategoryByCategoryType(CategoryType categoryType);
    List<Category> findAll();
}
