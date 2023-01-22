package com.shekhar.SpringAPIDemo.service;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import com.shekhar.SpringAPIDemo.error.BadRequestException;
import com.shekhar.SpringAPIDemo.error.CategoryNotFoundException;

import java.util.List;

public interface MainCategoryService {
    public MainCategory createMainCategory(MainCategory mainCategory);

    public List<MainCategory> getCategory() throws CategoryNotFoundException;

    public MainCategory getCategory(Long categoryId) throws CategoryNotFoundException;

    public MainCategory getCategory(String categoryName) throws CategoryNotFoundException;

    public MainCategory updateCategory(Long categoryId, MainCategory mainCategory) throws CategoryNotFoundException;

    public String deleteCategory(Long categoryId) throws CategoryNotFoundException;
}
