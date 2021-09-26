package com.codecool.item;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.codecool.item.domain.Item;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemListDto;

import java.util.List;

import static com.codecool.item.ItemConverter.DTOtoEntity;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@AllArgsConstructor
public class ItemService {

  private ItemRepository repository;

  public List<ItemDTO> getAllItems() {
    return repository.findAll().stream()
        .map(ItemConverter::entityToDTO)
        .collect(toList());
  }

  public void addItem(Item item) {
    repository.save(item);
  }

  public Item getItemById(Long id) {
    return repository.getItemById(id);
  }

  public ItemDTO getItemDTOById(Long id) {
    return ItemConverter.entityToDTO(repository.getItemById(id));
  }

  public List<ItemListDto> getItemsByNameContaining(String searchPhrase) {
    return repository.findItemsByNameContaining(searchPhrase).stream()
        .map(ItemConverter::itemToItemForListDTO)
        .collect(toList());
  }

  public List<ItemListDto> getItemsByCategory(String searchPhrase) {
    return repository.findItemsByCategoryName(searchPhrase)
        .stream()
        .map(ItemConverter::itemToItemForListDTO)
        .collect(toList());
  }

  public List<ItemListDto> getItemsByUserId(Long UserId) {
    return repository.findItemsByUserId(UserId)
        .stream()
        .map(ItemConverter::itemToItemForListDTO)
        .collect(toList());
  }

  List<Long> getItemsIdByUserId(long userId) {
    return repository.getItemsIdByUserId(userId);
  }

  public void updateItem(ItemDTO itemDto) {
    repository.save(DTOtoEntity(itemDto));
  }

  public void deleteItemById(Long id) {
    repository.deleteById(id);
  }
}
