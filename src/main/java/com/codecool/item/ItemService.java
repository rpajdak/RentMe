package com.codecool.item;

import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemForListDTO;

import java.util.List;

import static com.codecool.item.ItemConverter.DTOtoEntity;
import static com.codecool.item.ItemConverter.entitiesToDTO;
import static com.codecool.item.ItemConverter.entityToDTO;
import static java.util.stream.Collectors.toList;

public class ItemService {

  private ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<ItemDTO> getAllItems() {

    return itemRepository.findAll().stream()
        .map(ItemConverter::entityToDTO)
        .collect(toList());
  }

  public ItemDTO findById(Long id) {

    return entityToDTO(itemRepository.getItemById(id));
  }

  public void addItem(ItemDTO itemDto) {

    itemRepository.save(DTOtoEntity(itemDto));
  }

  public void updateItem(ItemDTO itemDto) {

    itemRepository.save(DTOtoEntity(itemDto));
  }

  public void deleteItemById(Long id) {

    itemRepository.deleteById(id);
  }

  public List<ItemDTO> findItemsByNameContaining(String searchPhrase) {
    return entitiesToDTO(itemRepository.findItemsByNameContaining(searchPhrase));
  }

  public List<ItemForListDTO> findItemsByCategory(String searchPhrase) {

    return itemRepository.findItemsByCategory(searchPhrase).stream()
        .map(ItemConverter::itemToItemForListDTO)
        .collect(toList());
  }

  public List<ItemForListDTO> findItemsByUser(Long UserId) {
    return itemRepository.findItemsByUser(UserId).stream()
        .map(ItemConverter::itemToItemForListDTO)
        .collect(toList());
  }
}
