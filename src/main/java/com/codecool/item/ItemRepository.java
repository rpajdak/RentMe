package com.codecool.item;

import com.codecool.item.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ItemRepository extends Repository<Item, Long> {

  Item getItemById(Long id);

  Item save(Item item);

  void deleteById(Long id);

  @Query("Select i from Item i where upper(i.name) like %:searchPhrase%")
  List<Item> findItemsByNameContaining(String searchPhrase);

  @Query("select i from Item i left join i.category c where upper(i.category.description) like %:searchPhrase%")
  List<Item> findItemsByCategory(String searchPhrase);

  @Query("select i from Item i left join i.owner u where i.owner.id = :userId")
  List<Item> findItemsByUser(Long userId);

  List<Item> findAll();
}
