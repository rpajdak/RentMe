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
    @Column(name= "name")
    private String name;
    @Column(name= "description")
    private String description;
    @Column(name= "price")
    private double price;
    @Column(name= "pic_url")
    private String picUrl;
    @Column(name= "owner_id")
    private Long ownerId;
    @ManyToOne
    @JoinColumn(name= "category_id")
    private Category category;

    public Item(String name, String description, double price, String picUrl, Long ownerId, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picUrl = picUrl;
        this.ownerId = ownerId;
        this.category = category;
    }
}
