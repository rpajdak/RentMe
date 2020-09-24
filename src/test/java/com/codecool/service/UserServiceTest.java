package com.codecool.service;

import com.codecool.dao.UserRepository;
import com.codecool.model.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

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
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("Joanna", users.get(0).getFirstName());
        Assertions.assertEquals("Miłosz", users.get(2).getFirstName());

    }


    @Test
    public void should_return_only_when_IsAdmin_is_true() {
        //when:
        List<AppUser> admins = userService.getAllAdmins();

        //then:
        Assertions.assertEquals(2, admins.size());
        Assertions.assertEquals("Joanna", admins.get(0).getFirstName());
        Assertions.assertEquals("Miłosz", admins.get(1).getFirstName());
        Assertions.assertEquals(2, admins.size());
    }


    @Test
    public void sould_return_only_when_IsAdmin_is_false(){
        //when:
        List<AppUser> admins = userService.getAllRenters();

        //then:
        Assertions.assertEquals(2,admins.size());
        Assertions.assertEquals("Rafał",admins.get(0).getFirstName());
        Assertions.assertEquals("Michał",admins.get(1).getFirstName());
        Assertions.assertEquals(2,admins.size());
    }

    private List<AppUser> prepareMockData() {
        AppUser appUser1 = new AppUser.Builder()
                .firstName("Joanna")
                .isAdmin(true)
                .build();

        AppUser appUser2 = new AppUser.Builder()
                .firstName("Rafał")
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