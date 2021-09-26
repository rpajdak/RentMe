package com.codecool.item;

import lombok.AllArgsConstructor;

import com.codecool.item.dto.AddItemRequestWrapper;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemListDto;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
@AllArgsConstructor
class ItemController {

  private ItemUseCase ItemUseCase;

  @GetMapping("/{id}")
  @ResponseBody
  @ResponseStatus(OK)
  public ItemDTO getItemById(@PathVariable("id") Long id) {
    return ItemUseCase.getItemDTOById(id);
  }

  @GetMapping(params = "nameContaining", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemListDto> getItemsByNameContaining(
      @RequestParam(value = "nameContaining") String nameContaining) {

    return ItemUseCase.getItemsByNameContaining(nameContaining.toUpperCase());
  }

  @GetMapping(params = "byCategory", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemListDto> getItemsByCategory(
      @RequestParam(value = "byCategory") String category) {
    return ItemUseCase.getItemsByCategory(category.toUpperCase());
  }

  @GetMapping(params = "byOwnerId", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemListDto> getItemsByUser(@RequestParam(value = "byOwnerId") Long userId) {
    return ItemUseCase.getItemsByUserId(userId);
  }

  @PostMapping()
  @ResponseBody
  @ResponseStatus(CREATED)
  public void addItem(
      @RequestBody AddItemRequestWrapper addItemRequestWrapper, Authentication authentication) {
    ItemUseCase.addItem(addItemRequestWrapper, authentication);
  }

  @PutMapping()
  @ResponseBody
  @ResponseStatus(OK)
  public void updateItem(@RequestBody ItemDTO itemDTO) {
    ItemUseCase.updateItem(itemDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  @ResponseStatus(NO_CONTENT)
  public void deleteItem(@PathVariable("id") Long id) {
    ItemUseCase.deleteItemById(id);
  }
}
