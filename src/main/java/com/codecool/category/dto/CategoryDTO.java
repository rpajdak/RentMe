package com.codecool.category.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String name;
    private double picUrl;
}
