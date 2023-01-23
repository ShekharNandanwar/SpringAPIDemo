package com.shekhar.SpringAPIDemo.repository;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MainCategoryRepositoryTest {

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        MainCategory mainCategory = MainCategory.builder()
                .mainCategoryName("User")
                .mainCategoryNote("All kinds of users")
                .build();
    entityManager.persist(mainCategory);
    }

    @Test
    @DisplayName("Get Main Category Name By Category Id")
    @Disabled
    public void whenFindById_thenReturnMainCategory(){
        MainCategory mainCategory = mainCategoryRepository.findById(1L).get();
        assertEquals(mainCategory.getMainCategoryName(), "User");
    }
}