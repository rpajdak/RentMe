package com.codecool.converter;

import com.codecool.model.AppUser;
import com.codecool.model.Item;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ItemConverter {

    public List<ItemDTO> entitiesToDTO(List<Item> items) {
        return items.stream()
                .map(item -> entityToDTO(item))
                .collect(Collectors.toList());
    }

    public ItemDTO entityToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setPicUrl(item.getPicUrl());

        return itemDTO;
    }

}
