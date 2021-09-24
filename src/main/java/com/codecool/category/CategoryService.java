package com.codecool.category;

import lombok.AllArgsConstructor;

import com.codecool.category.domain.Category;

import java.util.List;

@AllArgsConstructor
public class CategoryService {

    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

}
