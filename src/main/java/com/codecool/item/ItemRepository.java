package com.codecool.item;

import com.codecool.item.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface ItemRepository extends Repository<Item, Long> {

  Item getItemById(Long id);

  Item save(Item item);

  void deleteById(Long id);

  List<Item> findAll();

  @Query("Select i from Item i where upper(i.name) like %:searchPhrase%")
  List<Item> findItemsByNameContaining(String searchPhrase);

  @Query(value = "SELECT * FROM items i" +
      " LEFT JOIN categories_items ci ON i.id = ci.items_id" +
      " LEFT JOIN categories c ON ci.category_id = c.id" +
      " WHERE UPPER(c.name) LIKE :categoryName",
      nativeQuery = true)
  List<Item> findItemsByCategoryName(String categoryName);

  @Query(value = "SELECT * FROM items i" +
      " LEFT JOIN users_items ui ON i.id = ui.items_id" +
      " LEFT JOIN users u ON ui.user_id = u.id" +
      " WHERE UPPER(u.id) LIKE :userId",
      nativeQuery = true)
  List<Item> findItemsByUserId(Long userId);

  @Query(value = "SELECT items_id FROM users_items WHERE  user_id = :userId", nativeQuery = true)
  List<Long> getItemsIdByUserId(Long userId);
}
