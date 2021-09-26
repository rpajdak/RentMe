package com.codecool.item;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.codecool.category.CategoryService;
import com.codecool.category.domain.Category;
import com.codecool.item.domain.Item;
import com.codecool.item.dto.AddItemRequestWrapper;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemListDto;
import com.codecool.user.UserService;
import com.codecool.user.domain.User;
import org.springframework.security.core.Authentication;

import java.util.List;
import javax.transaction.Transactional;

import static com.codecool.item.ItemConverter.DTOtoEntity;

@RequiredArgsConstructor
public class ItemUseCase {

  @NonNull
  private final ItemService itemService;
  @NonNull
  private final UserService userService;
  @NonNull
  private final CategoryService categoryService;

  @Transactional
  public void addItem(AddItemRequestWrapper addItemRequestWrapper, Authentication authentication) {
    final Item item = DTOtoEntity(addItemRequestWrapper.getItemDTO());

    Category categoryOfTheItem =
        categoryService.getCategoryById(addItemRequestWrapper.getCategoryId());

    categoryOfTheItem.addItem(item);
    User OwnerOfTheItem = userService.getUserByEmail(authentication.getName());
    OwnerOfTheItem.addItem(item);

    itemService.addItem(item);
  }

  ItemDTO getItemDTOById(Long id) {
    return itemService.getItemDTOById(id);
  }

  List<ItemListDto> getItemsByNameContaining(String itemContaining) {
    return itemService.getItemsByNameContaining(itemContaining);
  }

  List<ItemListDto> getItemsByCategory(String category) {
    return itemService.getItemsByCategory(category);
  }

  List<ItemListDto> getItemsByUserId(Long userId) {
    return itemService.getItemsByUserId(userId);
  }

  void updateItem(ItemDTO itemDTO) {
    itemService.updateItem(itemDTO);
  }


  void deleteItemById(Long itemId) {
    itemService.deleteItemById(itemId);
  }
}
