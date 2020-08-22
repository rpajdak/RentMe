package com.codecool.service;

import com.codecool.dao.ItemRepository;
import com.codecool.model.Item;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Iterable<Item> getAllItems(){

        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id){

        return itemRepository.findById(id);
    }

    public void addItem(Item item){

        itemRepository.save(item);
    }

    public void updateItem(Item item){

        itemRepository.save(item);
    }

    public void deleteItemById(Long id){

        itemRepository.deleteById(id);
    }


}
