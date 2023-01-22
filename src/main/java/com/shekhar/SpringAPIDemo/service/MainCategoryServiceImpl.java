package com.shekhar.SpringAPIDemo.service;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import com.shekhar.SpringAPIDemo.error.CategoryNotFoundException;
import com.shekhar.SpringAPIDemo.repository.MainCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MainCategoryServiceImpl implements MainCategoryService{
    @Autowired
    private MainCategoryRepository mainCategoryRepository;
    @Override
    public MainCategory createMainCategory(MainCategory mainCategory){
        return mainCategoryRepository.save(mainCategory);
    }

    @Override
    public List<MainCategory> getCategory() throws CategoryNotFoundException {
        List<MainCategory> categories =  mainCategoryRepository.findAll();
        if(categories.isEmpty()){
            throw new CategoryNotFoundException("No Category found");
        }
        return categories;
    }

    @Override
    public MainCategory getCategory(Long categoryId) throws CategoryNotFoundException {
        Optional<MainCategory> mainCategoryOptional = mainCategoryRepository.findById(categoryId);
        if(!mainCategoryOptional.isPresent()){
            throw new CategoryNotFoundException("Does not found category with matching data");
        }
        return mainCategoryOptional.get();
    }

    @Override
    public MainCategory getCategory(String categoryName) throws CategoryNotFoundException {
        Optional<MainCategory> mainCategoryOptional = mainCategoryRepository.findByMainCategoryNameIgnoreCase(categoryName);
        if(!mainCategoryOptional.isPresent()){
            throw new CategoryNotFoundException("Does not found category with matching Name");
        }
        return mainCategoryOptional.get();
    }

    @Override
    public MainCategory updateCategory(Long categoryId, MainCategory mainCategory) throws CategoryNotFoundException {
        Optional<MainCategory> mainCategoryOptional = mainCategoryRepository.findById(categoryId);
        if(!mainCategoryOptional.isPresent()){
            throw new CategoryNotFoundException("Invalid update Request");
        }
        MainCategory mainCategory1 = mainCategoryOptional.get();
        if(Objects.nonNull(mainCategory.getMainCategoryName()) && !"".equalsIgnoreCase(mainCategory.getMainCategoryName())){
            mainCategory1.setMainCategoryName(mainCategory.getMainCategoryName());
        }
        if(Objects.nonNull(mainCategory.getMainCategoryNote()) && !"".equalsIgnoreCase(mainCategory.getMainCategoryNote())){
            mainCategory1.setMainCategoryNote(mainCategory.getMainCategoryNote());
        }
        return mainCategoryRepository.save(mainCategory1);
    }

    @Override
    public String deleteCategory(Long categoryId) throws CategoryNotFoundException {
        Optional<MainCategory> mainCategoryOptional = mainCategoryRepository.findById(categoryId);
        if(!mainCategoryOptional.isPresent()){
            throw new CategoryNotFoundException("Main Category does not exist");
        }
        mainCategoryRepository.deleteById(categoryId);
        return "Category:".concat(mainCategoryOptional.get().getMainCategoryName()).concat(" is deleted");
    }
}
