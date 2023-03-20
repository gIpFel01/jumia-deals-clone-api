package com.jumiadealsclone.ads.servicelayer.categorymanagement.impl;

import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.CategoryType;
import com.jumiadealsclone.ads.repositorylayer.CategoryRepository;
import com.jumiadealsclone.ads.servicelayer.categorymanagement.exception.CategoryExistsException;
import com.jumiadealsclone.ads.servicelayer.categorymanagement.interfaces.CategoryExists;
import org.springframework.stereotype.Service;

@Service
public class CategoryExistsImpl implements CategoryExists {

    private final CategoryRepository categoryRepository;

    public CategoryExistsImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category categoryExists(CategoryType categoryType) {
        Category category = categoryRepository.findCategoryByCategoryType(categoryType).orElse(null);
        if(category == null){
            throw new CategoryExistsException("Category not found");
        }
        return category;
    }
}
