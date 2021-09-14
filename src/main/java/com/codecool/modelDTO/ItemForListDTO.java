package com.codecool.modelDTO;

import com.codecool.category.domain.Category;
import com.codecool.user.dto.AppUserDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemForListDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private String picUrl;
    private AppUserDTO owner;
}
