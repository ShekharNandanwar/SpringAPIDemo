package com.shekhar.SpringAPIDemo.repository;

import com.shekhar.SpringAPIDemo.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Long> {
    Optional<MainCategory> findByMainCategoryNameIgnoreCase(String categoryName);
}
