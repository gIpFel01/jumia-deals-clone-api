package com.jumiadealsclone.ads.servicelayer.categorymanagement.interfaces;

import com.jumiadealsclone.ads.modelelayer.Category;
import com.jumiadealsclone.ads.modelelayer.CategoryType;

public interface CategoryExists {
    Category categoryExists(CategoryType categoryType);
}
