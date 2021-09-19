package com.codecool.item;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.codecool.item.dto.AddItemRequestWrapper;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemForListDTO;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RestController
@RequestMapping("/api/items")
@CrossOrigin
@RequiredArgsConstructor
public class ItemController {

  @NonNull
  private ItemService itemService;

  @GetMapping
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemDTO> getAllItems() {
    return itemService.getAllItems();
  }

  @GetMapping("/{id}")
  @ResponseBody
  @ResponseStatus(OK)
  public ItemDTO findById(@PathVariable("id") Long id) {
    return itemService.findById(id);
  }

  @GetMapping(params = "nameContaining", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemForListDTO> findItemsByNameContaining(
      @RequestParam(value = "nameContaining") String nameContaining) {

    return
        itemService.findItemsByNameContaining(nameContaining.toUpperCase());
  }

  @GetMapping(params = "byCategory", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemForListDTO> findItemsByCategory(
      @RequestParam(value = "byCategory") String byCategory) {

    return itemService.findItemsByCategory(byCategory.toUpperCase());
  }

  @GetMapping(params = "byOwnerId", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ItemForListDTO> findItemsByUser(@RequestParam(value = "byOwnerId") Long ownerId) {
    return itemService.findItemsByUser(ownerId);
  }

  @PostMapping()
  @ResponseBody
  @ResponseStatus(CREATED)
  public void addItem(@RequestBody AddItemRequestWrapper addItemRequestWrapper, Authentication authentication) {
    itemService.addItem(addItemRequestWrapper,authentication);
  }

  @PutMapping()
  @ResponseBody
  @ResponseStatus(OK)
  public void updateItem(@RequestBody ItemDTO itemDTO) {
    itemService.updateItem(itemDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  @ResponseStatus(NO_CONTENT)
  public void deleteItem(@PathVariable("id") Long id) {
    itemService.deleteItemById(id);
  }
}
