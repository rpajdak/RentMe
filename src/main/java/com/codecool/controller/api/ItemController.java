package com.codecool.controller.api;
import com.codecool.model.Item;
import com.codecool.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<Item> getAllItems(){
      return itemService.getAllItems();
    }

    @GetMapping()
    @ResponseBody
    public Optional<Item> findById(@RequestParam Long id){
        return itemService.findById(id);
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
