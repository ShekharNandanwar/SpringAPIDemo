package com.shekhar.SpringAPIDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mainCategoryId;
    @NotEmpty
    private String mainCategoryName;
    @NotEmpty
    private String mainCategoryNote;

}
