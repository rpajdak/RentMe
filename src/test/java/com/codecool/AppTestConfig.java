package com.codecool;

import com.codecool.category.CategoriesController;
import com.codecool.item.ItemController;
import com.codecool.user.UserController;
import com.codecool.user.domain.AppUserConverter;
import com.codecool.item.ItemConverter;
import com.codecool.category.domain.Category;
import com.codecool.category.CategoryService;
import com.codecool.item.ItemService;
import com.codecool.user.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class AppTestConfig {

    @Bean
    public AppUserConverter appUserConverter() {
        return new AppUserConverter();
    }

    @Bean
    public ItemConverter itemConverter() {
        return new ItemConverter();
    }

    @Bean
    public UserController userController() {
        return new UserController(userService());
    }

    @Bean
    public CategoriesController categoriesController() {
        return new CategoriesController(categoryService());
    }

    @Bean
    public CategoryService categoryService() {
        return Mockito.mock(CategoryService.class);
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    public ItemService itemService() {
        return Mockito.mock(ItemService.class);
    }

    @Bean
    public Category category() {
        return Mockito.mock(Category.class);
    }

    @Bean
    public ItemController itemController() {
        return new ItemController(itemService(), itemConverter());
    }
}

