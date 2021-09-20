package com.codecool.item.dto;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @JsonProperty("id")
    Long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("description")
    String description;
    @JsonProperty("price")
    double price;
    @JsonProperty("categoryName")
    String categoryName;
    @JsonProperty("picUrl")
    String picUrl;
    @JsonProperty("ownerName")
    String ownerName;
}
