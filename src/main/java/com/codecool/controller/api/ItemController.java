package com.codecool.controller.api;
import com.codecool.converter.ItemConverter;
import com.codecool.model.Item;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Controller
@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class ItemController {

    private ItemService itemService;
    private ItemConverter itemConverter;

    public ItemController(ItemService itemService, ItemConverter itemConverter) {
        this.itemConverter = itemConverter;
        this.itemService = itemService;
    }


    @GetMapping
    @ResponseBody
    public List<ItemDTO> getAllItems() {
        return itemConverter.entitiesToDTO(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ItemDTO findById(@PathVariable("id") Long id) {
        return itemConverter.entityToDTO(itemService.findById(id));
    }


    @GetMapping("/list/{searchPhrase}")
    @ResponseBody
    public List<ItemDTO> findItemsByNameContaining(@PathVariable("searchPhrase") String searchPhrase) {
        return itemConverter.entitiesToDTO(itemService.findItemsByNameContaining(searchPhrase.toUpperCase()));
    }

    @GetMapping("/categories/{searchPhrase}")
    @ResponseBody
    public List<ItemDTO> findItemsByCategory(@PathVariable("searchPhrase") String searchPhrase) {
        return itemConverter.entitiesToDTO(itemService.findItemsByCategory(searchPhrase.toUpperCase()));
    }


    //, dodac DTO zamiast Item
    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }


    @PutMapping()
    @ResponseBody
    @ResponseStatus(OK)
    public void updateItem(@RequestBody Item item) {

        itemService.updateItem(item);
    }

    @DeleteMapping()
    @ResponseBody
    @ResponseStatus(NO_CONTENT)
    public void deleteItem(@RequestParam Long id) {
        itemService.deleteItemById(id);
    }

}