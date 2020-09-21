package com.codecool;

import com.codecool.model.AppUser;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppTestConfig.class})
@WebAppConfiguration
public class AppUserControllerIntegrationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_return_user_by_id() throws Exception {
        int id = 1;
        when(userService.getUserById(id)).thenReturn(new AppUser.Builder()
                .firstName("Joanna")
                .lat(23.222)
                .lng(23.333)
                .build());

        mockMvc.perform(get("/users/renters/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.firstName").value("Joanna"));

    }

    @Test
    public void should_return_created_status_code_when_user_added() throws Exception {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setAddress("krakow");
        appUserDTO.setLng(123.33);
        appUserDTO.setLat(123.22);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(appUserDTO))
        ).andExpect(status().isCreated());
        verify(userService, times(1)).addUser(any(AppUser.class));
    }
}




