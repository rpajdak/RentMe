//package com.codecool.item;
//
//import com.codecool.item.dto.ItemDTO;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@Import({ ItemController.class })
//class ItemControllerTest {
//
//  @Autowired
//  ItemUseCase itemUseCase;
//
//  @Autowired
//  private WebApplicationContext webApplicationContext;
//
//  private MockMvc mockMvc;
//
//  @Before
//  public void setUp() throws Exception {
//    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//  }
//
//  @Test
//  public void should_return_item_by_id() throws Exception {
//    Long id = 1L;
//    ItemDTO itemDTO = makeItemDto();
//    Mockito.when(itemUseCase.getItemDTOById(id))
//        .thenReturn(itemDTO);
//
//    mockMvc.perform(get("/api/items/{id}", id))
//        .andExpect(status().isOk())
////        .andExpect(content().contentType("application/json"))
//        .andExpect(jsonPath("$.name").value("Item"))
//        .andExpect(jsonPath("$.description").value("Example"))
//        .andExpect(jsonPath("$.picUrl").value("picture.jpg"))
//        .andExpect(jsonPath("$.price").value(13.99));
//  }
//
//  private static ItemDTO makeItemDto() {
//    return ItemDTO.builder()
//        .name("Item")
//        .price(13.99)
//        .picUrl("picture.jpg")
//        .description("Example")
//        .build();
//  }
//}
