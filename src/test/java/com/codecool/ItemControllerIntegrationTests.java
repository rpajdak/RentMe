package com.codecool;


import com.codecool.item.ItemService;
import com.codecool.item.dto.AddItemRequestWrapper;
import com.codecool.item.dto.ItemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppTestConfig.class})
@WebAppConfiguration
public class ItemControllerIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private ItemService itemService;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_return_item_by_id() throws Exception {
        Long id = 1L;
        ItemDTO itemDTO = makeItemDto();
        when(itemService.getItemDTOById(id))
                .thenReturn(itemDTO);

        mockMvc.perform(get("/api/items/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Item"))
                .andExpect(jsonPath("$.description").value("Example"))
                .andExpect(jsonPath("$.picUrl").value("picture.jpg"))
                .andExpect(jsonPath("$.price").value(13.99));

    }

    @Test
    public void should_return_created_status_code_when_item_added() throws Exception {
        ItemDTO itemDTO = makeItemDto();

        mockMvc.perform(post("/api/items")
                .contentType(APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(itemDTO))
        ).andExpect(status().isCreated());
        verify(itemService, times(1)).addItem(any(AddItemRequestWrapper.class), any(Authentication.class));
    }

    @Test
    public void should_return_no_content_status_code_when_item_deleted() throws Exception {
        mockMvc.perform(delete("/api/items/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void should_return_OK_status_code_when_item_updated() throws Exception {

        mockMvc.perform(put("/api/items")
                .contentType(APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(makeItemDto())))
                .andExpect(status().isOk());
    }

    private static ItemDTO makeItemDto() {
        return ItemDTO.builder()
                .name("Item")
                .price(13.99)
                .picUrl("picture.jpg")
                .description("Example")
                .build();
    }
}
