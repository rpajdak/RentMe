package com.codecool.controller.api;
import com.codecool.converter.ItemConverter;
import com.codecool.model.Item;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.modelDTO.ItemForListDTO;
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
    @ResponseStatus(OK)
    public List<ItemDTO> getAllItems() {
        return itemConverter.entitiesToDTO(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(OK)
    public ItemDTO findById(@PathVariable("id") Long id) {
        return itemConverter.entityToDTO(itemService.findById(id));
    }

    @GetMapping("/list/{searchPhrase}")
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> findItemsByNameContaining(@PathVariable("searchPhrase") String searchPhrase) {
        return itemConverter.itemsToItemsForListDTO(itemService.findItemsByNameContaining(searchPhrase.toUpperCase()));
    }

    @GetMapping("/categories/{searchPhrase}")
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> findItemsByCategory(@PathVariable("searchPhrase") String searchPhrase) {
        return itemConverter.itemsToItemsForListDTO(itemService.findItemsByCategory(searchPhrase.toUpperCase()));
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public void addItem(@RequestBody ItemDTO item) {
        itemService.addItem(itemConverter.DTOtoEntity(item));
    }

    @PutMapping()
    @ResponseBody
    @ResponseStatus(OK)
    public void updateItem(@RequestBody ItemDTO item) {
        itemService.updateItem(itemConverter.DTOtoEntity(item));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(NO_CONTENT)
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
    }

}