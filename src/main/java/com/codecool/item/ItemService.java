package com.codecool.item;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.codecool.category.CategoryService;
import com.codecool.category.domain.Category;
import com.codecool.item.domain.Item;
import com.codecool.item.dto.AddItemRequestWrapper;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemForListDTO;
import com.codecool.user.UserService;
import com.codecool.user.domain.AppUser;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;

import static com.codecool.item.ItemConverter.DTOtoEntity;
import static com.codecool.item.ItemConverter.entityToDTO;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@AllArgsConstructor
public class ItemService {

  private ItemRepository itemRepository;

  private UserService userService;

  private CategoryService service;

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

  @Transactional
  public void addItem(AddItemRequestWrapper addItemRequestWrapper, Authentication authentication) {
    final Item item = DTOtoEntity(addItemRequestWrapper.getItemDTO());

    Category categoryById = service.getCategoryById(addItemRequestWrapper.getCategoryId());
    categoryById.addItem(item);

    AppUser entityByEmail = userService.getEntityByEmail("b@gmail.com");
    entityByEmail.addItem(item);

    Item savedItem = itemRepository.save(item);
  }

  public void updateItem(ItemDTO itemDto) {

    itemRepository.save(DTOtoEntity(itemDto));
  }

  public void deleteItemById(Long id) {

    itemRepository.deleteById(id);
  }

  public List<ItemForListDTO> findItemsByNameContaining(String searchPhrase) {
    return itemRepository.findItemsByNameContaining(searchPhrase).stream()
        .map(ItemConverter::itemToItemForListDTO)
        .collect(toList());
  }

  public List<ItemForListDTO> findItemsByCategory(String searchPhrase) {
    return null;
//    return itemRepository.findItemsByCategory(searchPhrase).stream()
//        .map(ItemConverter::itemToItemForListDTO)
//        .collect(toList());
  }

  public List<ItemForListDTO> findItemsByUser(Long UserId) {
    return null;
//    return itemRepository.findItemsByUser(UserId).stream()
//        .map(ItemConverter::itemToItemForListDTO)
//        .collect(toList());
  }
}
