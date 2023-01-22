package com.shekhar.SpringAPIDemo.service;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import com.shekhar.SpringAPIDemo.error.CategoryNotFoundException;
import com.shekhar.SpringAPIDemo.repository.MainCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainCategoryServiceTest {

    @Autowired
    private MainCategoryService mainCategoryService;

    @MockBean
    private MainCategoryRepository mainCategoryRepository;
    @BeforeEach
    void setUp() {
        MainCategory mainCategory = MainCategory.builder()
                .mainCategoryName("Product")
                .mainCategoryNote("All types of Products")
                .build();
        Mockito.when(mainCategoryRepository.findByMainCategoryNameIgnoreCase("Product"))
                .thenReturn(Optional.ofNullable(mainCategory));
    }
    @Test
    @DisplayName("Get Data based on valid MainCategory Name")
    public void whenValidMainCategoryName_thenMainCategoryShouldFound() throws CategoryNotFoundException {
        String mainCategoryName = "Product";
        MainCategory found = mainCategoryService.getCategory(mainCategoryName);
        assertEquals(mainCategoryName, found.getMainCategoryName());
    }
}