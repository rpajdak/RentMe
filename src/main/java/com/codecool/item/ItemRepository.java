package com.codecool.item;

import com.codecool.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends Repository<Item, Long> {

    Item getItemById(Long id);

    Item save(Item item);

    void deleteById(Long id);

    List<Item> findAll();

    @Query("Select i from Item i where upper(i.name) like %:searchPhrase%")
    List<Item> findItemsByNameContaining(String searchPhrase);

    @Query(value = "Select * from items i" +
            " left join categories_items ci on i.id = ci.items_id" +
            " left join categories c on ci.category_id = c.id" +
            " where upper(c.name) like :searchPhrase",
            nativeQuery = true)
    List<Item> findItemsByCategoryName(String searchPhrase);

    @Query(value = "Select * from items i" +
            " left join users_items ui on i.id = ui.items_id" +
            " left join users u on ui.user_id = u.id" +
            " where upper(u.id) like :userId",
            nativeQuery = true)
    List<Item> findItemsByUserId(Long userId);

    @Query(value = "SELECT items_id FROM users_items WHERE  user_id = :userId", nativeQuery = true)
    List<Long> getItemsIdByUserId(Long userId);
}
