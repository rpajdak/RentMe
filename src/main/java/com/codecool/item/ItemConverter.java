package com.codecool.item;

import com.codecool.item.domain.Item;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemForListDTO;
import com.codecool.user.domain.AppUserConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemConverter {

  private AppUserConverter appUserConverter;

  public ItemConverter() {
    this.appUserConverter = new AppUserConverter();
  }

  public static List<ItemDTO> entitiesToDTO(List<Item> items) {
    return items.stream()
        .map(item -> entityToDTO(item))
        .collect(Collectors.toList());
  }

  public static ItemDTO entityToDTO(Item item) {
    return ItemDTO.builder()
        .categoryName(item.getCategory().getDescription())
        .description(item.getDescription())
        .id(item.getId())
        .name(item.getName())
        .ownerName(item.getOwner().getFullName())
        .picUrl(item.getPicUrl())
        .price(item.getPrice())
        .build();
  }

  public static ItemForListDTO itemToItemForListDTO(Item item) {
    ItemForListDTO itemForListDTO = new ItemForListDTO();
    itemForListDTO.setId(item.getId());
    itemForListDTO.setName(item.getName());
    itemForListDTO.setDescription(item.getDescription());
    itemForListDTO.setPrice(item.getPrice());
    itemForListDTO.setPicUrl(item.getPicUrl());
    itemForListDTO.setCategory(item.getCategory());
    itemForListDTO.setOwner(AppUserConverter.entityToDTO(item.getOwner()));
    return itemForListDTO;
  }

  public List<ItemForListDTO> itemsToItemsForListDTO(List<Item> items) {
    return items.stream()
        .map(item -> itemToItemForListDTO(item))
        .collect(Collectors.toList());
  }

  //TODO hmmm??
  public static Item DTOtoEntity(ItemDTO itemDTO) {
    Item item = new Item();
    item.setId(itemDTO.getId());
    item.setName(itemDTO.getName());
//    item.setCategory(itemDTO.getCategory());
    item.setDescription(itemDTO.getDescription());
//    item.setOwner(itemDTO.getOwner());
    item.setPrice(itemDTO.getPrice());
    item.setPicUrl(itemDTO.getPicUrl());
    return item;
  }
}
