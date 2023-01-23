package com.shekhar.SpringAPIDemo.controller;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import com.shekhar.SpringAPIDemo.error.CategoryNotFoundException;
import com.shekhar.SpringAPIDemo.service.MainCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@WebMvcTest(MainCategoryController.class)
class MainCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainCategoryService mainCategoryService;

    private MainCategory mainCategory;
    @BeforeEach
    void setUp() {
        mainCategory = MainCategory.builder()
                .mainCategoryName("Person")
                .mainCategoryNote("All Types of persons")
                .mainCategoryId(1L)
                .build();
    }

    @Test
    @DisplayName("Save Main Category")
    void createMainCategory() throws Exception {
        MainCategory inputMainCategory = MainCategory.builder()
                .mainCategoryName("Person")
                .mainCategoryNote("All Types of persons")
                .build();
        Mockito.when(mainCategoryService.createMainCategory(inputMainCategory))
                .thenReturn(mainCategory);
        mockMvc.perform(MockMvcRequestBuilders.post("/mainCategory")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"mainCategoryName\": \"Person\",\n" +
                        "\"mainCategoryNote\": \"All Types of persons\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get Department information by Id")
    @Disabled
    void getCategory() throws Exception {
        Mockito.when(mainCategoryService.getCategory(1L))
                .thenReturn(mainCategory);
        mockMvc.perform(MockMvcRequestBuilders.get("/mainCategory/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mainCategoryName").value(mainCategory.getMainCategoryName()));
    }
}