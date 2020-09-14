package com.codecool.controller.api;
import com.codecool.converter.ItemConverter;
import com.codecool.model.Item;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/items")
@CrossOrigin
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

    @GetMapping("/list/{searchPhrase}")
    @ResponseBody
    public List<ItemDTO> findItemsByNameContaining(@PathVariable("searchPhrase") String searchPhrase){
        return itemConverter.entitiesToDTO(itemService.findItemsByNameContaining(searchPhrase.toUpperCase()));
    }

    @GetMapping("/list/byCategory/{searchPhrase}")
    @ResponseBody
    public List<ItemDTO> findItemsByCategory(@PathVariable("searchPhrase") String searchPhrase){
        return itemConverter.entitiesToDTO(itemService.findItemsByCategory(searchPhrase));
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


    public static Double calculate(final double numberOne, final String operation, final double numberTwo)
    {

        if(operation == "+"){
            return numberOne + numberTwo;
        }

        else if(operation == "-"){
            return  numberOne - numberTwo;
        }

        else if(operation == "*"){
            return  numberOne * numberTwo;
        }

        else if(operation == "/"){
            if(numberTwo == 0){
                return null;
            }
            return numberOne/numberTwo;
        }
        else
            return null;
    }


    public static void main(String[] args) {
        System.out.println(calculate(-3, "*", 0));
    }

}
