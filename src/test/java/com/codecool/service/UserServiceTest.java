package com.codecool.service;

import com.codecool.dao.UserRepository;
import com.codecool.model.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        given(userRepository.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void should_return_all_users() {
        //when:
        List<AppUser> users = userService.getAllAppUsers();

        //then:
        Assertions.assertEquals(users.size(),4);
        Assertions.assertEquals(users.get(0).getFirstName(),"Joanna");
        Assertions.assertEquals(users.get(2).getFirstName(),"Miłosz");

    }


    private List<AppUser> prepareMockData() {
        AppUser appUser1 = new AppUser.Builder()
                .firstName("Joanna")
                .isAdmin(true)
                .build();

        AppUser appUser2 = new AppUser.Builder()
                .firstName("Rafal")
                .isAdmin(false)
                .build();
        AppUser appUser3 = new AppUser.Builder()
                .firstName("Miłosz")
                .isAdmin(true)
                .build();

        AppUser appUser4 = new AppUser.Builder()
                .firstName("Michał")
                .isAdmin(false)
                .build();

        return Arrays.asList(appUser1, appUser2, appUser3, appUser4);
    }

}