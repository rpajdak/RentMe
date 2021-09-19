package com.codecool.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.codecool.item.domain.Item;

import java.util.Collection;
import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "category_id")
  private Long id;
  @Column(name = "description")
  private String description;
  @Column(name = "pic_url")
  private String picUrl;
//  @OneToMany(cascade = ALL, orphanRemoval = true)
//  @JoinColumn(name = "category_id", updatable = false, nullable = false)
@OneToMany(
    cascade = CascadeType.ALL,
    orphanRemoval = true
)
  Collection<Item> itemList;

  public void addItem(Item item) {
    itemList.add(item);
  }
}
