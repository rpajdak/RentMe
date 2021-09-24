package com.codecool.item;

import com.codecool.item.domain.Item;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemForListDTO;
import com.codecool.user.UserConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemConverter {

    private UserConverter userConverter;

    public ItemConverter() {
        this.userConverter = new UserConverter();
    }

    public static ItemDTO entityToDTO(Item item) {
        return ItemDTO.builder()
                .description(item.getDescription())
                .id(item.getId())
                .name(item.getName())
                .picUrl(item.getPicUrl())
                .price(item.getPrice())
                .build();
    }

    public static List<ItemDTO> entitiesToDTO(List<Item> items) {
        return items.stream()
                .map(item -> entityToDTO(item))
                .collect(Collectors.toList());
    }

    public static ItemForListDTO itemToItemForListDTO(Item item) {
        ItemForListDTO itemForListDTO = new ItemForListDTO();
        itemForListDTO.setId(item.getId());
        itemForListDTO.setName(item.getName());
        itemForListDTO.setDescription(item.getDescription());
        itemForListDTO.setPrice(item.getPrice());
        itemForListDTO.setPicUrl(item.getPicUrl());
        return itemForListDTO;
    }

    public List<ItemForListDTO> itemsToItemsForListDTO(List<Item> items) {
        return items.stream()
                .map(ItemConverter::itemToItemForListDTO)
                .collect(Collectors.toList());
    }

    public static Item DTOtoEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setItemId(UUID.randomUUID().toString());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        item.setPicUrl(itemDTO.getPicUrl());
        return item;
    }
}
