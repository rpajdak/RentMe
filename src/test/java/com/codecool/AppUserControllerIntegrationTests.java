//package com.codecool;
//
//import com.codecool.user.UserService;
//import com.codecool.user.domain.AppUser;
//import com.codecool.user.dto.AppUserDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { AppTestConfig.class })
//@WebAppConfiguration
//public class AppUserControllerIntegrationTests {
//
//  @Autowired
//  private WebApplicationContext webApplicationContext;
//
//  private MockMvc mockMvc;
//
//  @Autowired
//  private UserService userService;
//
//  @Before
//  public void setUp() throws Exception {
//    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//  }
//
//  @Test
//  public void should_return_user_by_id() throws Exception {
//    int id = 1;
//    when(userService.getUserById(id)).thenReturn(AppUserDTO.builder().build());
//
//    mockMvc.perform(get("/users/renters/{id}", id))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"))
//        .andExpect(jsonPath("$.firstName").value("Joanna"));
//
//  }
//
//  @Test
//  public void should_return_created_status_code_when_user_added() throws Exception {
//    AppUserDTO appUserDTO = new AppUserDTO();
//    appUserDTO.setAddress("krakow");
//    appUserDTO.setLng(123.33);
//    appUserDTO.setLat(123.22);
//
//    mockMvc.perform(post("/users")
//        .contentType(MediaType.APPLICATION_JSON_VALUE)
//        .content(new ObjectMapper().writeValueAsString(appUserDTO))
//    ).andExpect(status().isCreated());
//    verify(userService, times(1)).addUser(any(AppUser.class));
//  }
//
//  @Test
//  public void should_return_list_of_admins() throws Exception {
//    List<AppUser> admins = Arrays.asList(
//        new AppUser.Builder()
//            .firstName("rafal")
//            .lastName("Nowak")
//            .build(),
//        new AppUser.Builder()
//            .firstName("Michał")
//            .lastName("Stoch")
//            .build());
//
//    when(userService.getAllAdmins()).thenReturn(admins);
//
//    mockMvc.perform(get("/users/admins"))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"))
//        .andExpect(jsonPath("$", hasSize(2)))
//        .andExpect(jsonPath("$.[1].firstName").value("Michał"));
//  }
//
//  @Test
//  public void should_return_no_content_code_when_user_removed() throws Exception {
//
//    AppUserDTO appUserDTO = new AppUserDTO();
//    appUserDTO.setId((long) 1);
//
//    mockMvc.perform(delete("/users/{id}", 1))
//        .andExpect(status().isNoContent());
//
//    verify(userService, times(1)).deleteUser(any(Long.class));
//
//  }
//}
//
//
//
//
