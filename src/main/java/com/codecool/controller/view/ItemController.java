package com.codecool.controller.view;

import com.codecool.dao.ItemRepository;
import com.codecool.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addItem(){
        itemRepository.save(new Item("drill", "description", 12, "url", 1L));
        return "it has been completed";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

//    @PostMapping("/add")
//    public Item addItem(@RequestBody Item item ){
//        return itemRepository.save(item);
//    }


}
