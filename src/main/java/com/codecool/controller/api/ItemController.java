package com.codecool.controller.api;
import com.codecool.converter.ItemConverter;
import com.codecool.model.Item;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;
    private ItemConverter itemConverter;

    public ItemController(ItemService itemService, ItemConverter itemConverter){
        this.itemConverter = itemConverter;
        this.itemService = itemService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<ItemDTO> getAllItems(){
        return itemConverter.entitiesToDTO(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ItemDTO findById(@PathVariable("id") Long id){
        return  itemConverter.entityToDTO(itemService.findById(id));

    }

    @PostMapping()
    @ResponseBody
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @PutMapping()
    @ResponseBody
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping()
    @ResponseBody
    public void deleteItem(@RequestParam Long id){
        itemService.deleteItemById(id);
    }

}
