package com.codecool.category;

import com.codecool.category.domain.Category;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CategoryRepository extends Repository<Category, Long> {

  List<Category> findAll();
}
