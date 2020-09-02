package com.codecool.modelDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
}
