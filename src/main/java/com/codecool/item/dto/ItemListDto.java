package com.codecool.item.dto;

import com.codecool.category.domain.Category;
import com.codecool.user.dto.UserDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemListDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private String picUrl;
    private UserDTO owner;
}
