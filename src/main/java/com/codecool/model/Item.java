package com.codecool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String description;
    private double price;
    private String picUrl;
    private Long ownerId;
    private Long categoryId;

    public Item(String name, String description, double price, String picUrl, Long ownerId, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picUrl = picUrl;
        this.ownerId = ownerId;
        this.categoryId = categoryId;

    }
}
