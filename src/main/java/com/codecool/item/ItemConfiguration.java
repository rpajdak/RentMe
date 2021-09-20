package com.codecool.item;

import com.codecool.category.CategoryService;
import com.codecool.user.UserService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
public class ItemConfiguration {
    @Bean
    ItemService itemService(ItemRepository itemRepository, UserService userService, CategoryService categoryService) {
        return new ItemService(itemRepository, userService, categoryService);
    }
}
