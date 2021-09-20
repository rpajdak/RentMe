package com.codecool.category;

import com.codecool.category.domain.Category;
import com.codecool.category.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    public CategoryDTO entityToDTO(Category category) {
        return new CategoryDTO();
    }

    public List<CategoryDTO> entitiesToDTO(List<Category> categories) {
        return categories.stream()
                .map(category -> entityToDTO(category))
                .collect(Collectors.toList());
    }

}
