package com.codecool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

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
    @ManyToOne
    @JoinColumn(name= "owner_id")
    private AppUser owner;
    @ManyToOne
    @JoinColumn(name= "category_id")
    private Category category;

    public Item(String name, String description, double price, String picUrl, AppUser owner, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picUrl = picUrl;
        this.owner = owner;
        this.category = category;
    }
}
