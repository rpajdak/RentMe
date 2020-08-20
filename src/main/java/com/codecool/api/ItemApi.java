package com.codecool.api;

import com.codecool.model.Item;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemApi {

    @GetMapping("/all")
    public Item getAll(){
        return null;
    }

    @GetMapping
    public Item getItemById(@RequestParam Long id){
        return null;
    }


//    @PostMapping
//    @PutMapping
//    @DeleteMapping
}
