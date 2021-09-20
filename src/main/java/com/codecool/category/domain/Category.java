package com.codecool.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.codecool.item.domain.Item;

import java.util.Collection;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String name;
    @Column(name = "pic_url")
    private String picUrl;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }
}
