package com.shekhar.SpringAPIDemo.controller;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import com.shekhar.SpringAPIDemo.error.BadRequestException;
import com.shekhar.SpringAPIDemo.error.CategoryNotFoundException;
import com.shekhar.SpringAPIDemo.service.MainCategoryService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainCategoryController {
    @Autowired
    private MainCategoryService mainCategoryService;
    private Logger LOGGER = LoggerFactory.getLogger(Logger.class);
    /*
    POST: Create Main Category
     */
    @PostMapping("/mainCategory")
    public MainCategory createMainCategory(@Valid @RequestBody MainCategory mainCategory){
        LOGGER.info("Create New Main Category");
        return mainCategoryService.createMainCategory(mainCategory);
    }
    /*
    GET: Get all Main Category entries
     */
    @GetMapping("/mainCategory")
    public List<MainCategory> getCategory() throws CategoryNotFoundException {
        LOGGER.info("Show All Main Categories");
        return mainCategoryService.getCategory();
    }
    /*
    GET: Get Main Category by Id
     */
    @GetMapping("/mainCategory/{id}")
    public MainCategory getCategory(@PathVariable("id") Long categoryId) throws CategoryNotFoundException{
        LOGGER.info("Get Main Category By Id");
        return mainCategoryService.getCategory(categoryId);
    }
    /*
    GET: Get Main Category by Name
     */
    @GetMapping("/mainCategory/name/{name}")
    public MainCategory getCategory(@PathVariable("name") String categoryName) throws CategoryNotFoundException{
        LOGGER.info("Get Main Category by Name");
        return mainCategoryService.getCategory(categoryName);
    }
    /*
    PUT: Modify Category Details
     */
    @PutMapping("/mainCategory/{id}")
    public MainCategory updateCategory(@PathVariable("id") Long categoryId, @RequestBody MainCategory mainCategory) throws CategoryNotFoundException{
        LOGGER.info("Update Main Category by Id");
        return mainCategoryService.updateCategory(categoryId, mainCategory);
    }

    @DeleteMapping("mainCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId) throws CategoryNotFoundException{
        LOGGER.info("Delete Main Category by Id");
        return  mainCategoryService.deleteCategory(categoryId);
    }
}
