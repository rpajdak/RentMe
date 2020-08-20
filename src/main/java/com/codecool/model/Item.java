package com.codecool.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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



    public Item(){

    }

    public Item(String name, String description, double price, String picUrl, Long ownerId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picUrl = picUrl;
        this.ownerId = ownerId;

    }
}
