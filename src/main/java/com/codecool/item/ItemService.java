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
import com.codecool.user.domain.User;
import org.springframework.security.core.Authentication;

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
    private CategoryService categoryService;

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(ItemConverter::entityToDTO)
                .collect(toList());
    }
    public Item getItemById(Long id) {
        return itemRepository.getItemById(id);
    }
    public ItemDTO getItemDTOById(Long id) {
        return ItemConverter.entityToDTO(itemRepository.getItemById(id));
    }

    public List<ItemForListDTO> getItemsByNameContaining(String searchPhrase) {
        return itemRepository.findItemsByNameContaining(searchPhrase).stream()
                .map(ItemConverter::itemToItemForListDTO)
                .collect(toList());
    }

    public List<ItemForListDTO> getItemsByCategory(String searchPhrase) {
        return itemRepository.findItemsByCategoryName(searchPhrase)
                .stream()
                .map(ItemConverter::itemToItemForListDTO)
                .collect(toList());
    }

    public List<ItemForListDTO> getItemsByUserId(Long UserId) {
        return itemRepository.findItemsByUserId(UserId)
                .stream()
                .map(ItemConverter::itemToItemForListDTO)
                .collect(toList());
    }

    List<Long> getItemsIdByUserId(long userId) {
        return itemRepository.getItemsIdByUserId(userId);
    }

    @Transactional
    public void addItem(AddItemRequestWrapper addItemRequestWrapper, Authentication authentication) {
        final Item item = DTOtoEntity(addItemRequestWrapper.getItemDTO());

        Category categoryOfTheItem = categoryService.getCategoryById(addItemRequestWrapper.getCategoryId());
        categoryOfTheItem.addItem(item);

        User OwnerOfTheItem = userService.getUserByEmail(authentication.getName());
        OwnerOfTheItem.addItem(item);

        itemRepository.save(item);
    }

    public void updateItem(ItemDTO itemDto) {
        itemRepository.save(DTOtoEntity(itemDto));
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
