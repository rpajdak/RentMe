package com.codecool.dao;

import com.codecool.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
    //or CrudRepository<Employee, Long>
}
