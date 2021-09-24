package com.codecool.item.dto;

import lombok.Data;

@Data
public class AddItemRequestWrapper {
    Long categoryId;
    ItemDTO itemDTO;
}
