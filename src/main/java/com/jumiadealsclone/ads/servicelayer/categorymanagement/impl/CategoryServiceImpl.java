package com.jumiadealsclone.ads.servicelayer.categorymanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.CategoryType;
import com.jumiadealsclone.ads.servicelayer.categorymanagement.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Override
    public Category findCategoryByCategoryType(CategoryType categoryType) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
