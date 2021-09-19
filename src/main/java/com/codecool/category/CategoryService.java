package com.codecool.category;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.codecool.category.domain.Category;

import java.util.List;

@RequiredArgsConstructor
public class CategoryService {

  @NonNull
  CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }


  public Category getCategoryById(Long id) {
    return categoryRepository.getCategoryById(id);
  }

  public Category updateCategory(Category categoryById) {
    return categoryRepository.save(categoryById);
  }
}
