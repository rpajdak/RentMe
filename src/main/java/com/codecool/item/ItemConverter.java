package com.codecool.item;

import com.codecool.item.domain.Item;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemListDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemConverter {

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

  public static ItemListDto itemToItemForListDTO(Item item) {
    ItemListDto itemListDto = new ItemListDto();
    itemListDto.setId(item.getId());
    itemListDto.setName(item.getName());
    itemListDto.setDescription(item.getDescription());
    itemListDto.setPrice(item.getPrice());
    itemListDto.setPicUrl(item.getPicUrl());
    return itemListDto;
  }

  public List<ItemListDto> itemsToItemsForListDTO(List<Item> items) {
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
