package com.codecool;

import com.codecool.controller.api.UserController;
import com.codecool.converter.AppUserConverter;
import com.codecool.dao.UserRepository;
import com.codecool.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    public UserController userController() {
        return new UserController(userService(), appUserConverter());
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }


}


