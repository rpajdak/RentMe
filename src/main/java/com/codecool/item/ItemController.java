package com.codecool.item;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.codecool.item.dto.AddItemRequestWrapper;
import com.codecool.item.dto.ItemDTO;
import com.codecool.item.dto.ItemForListDTO;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
@AllArgsConstructor
public class ItemController {

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
    public ItemDTO getItemById(@PathVariable("id") Long id) {
        return itemService.getItemDTOById(id);
    }

    @GetMapping(params = "nameContaining", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> getItemsByNameContaining(
            @RequestParam(value = "nameContaining") String nameContaining) {

        return itemService.getItemsByNameContaining(nameContaining.toUpperCase());
    }

    @GetMapping(params = "byCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> getItemsByCategory(
            @RequestParam(value = "byCategory") String category) {
        return itemService.getItemsByCategory(category.toUpperCase());
    }

    @GetMapping(params = "byOwnerId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> getItemsByUser(@RequestParam(value = "byOwnerId") Long userId) {
        return itemService.getItemsByUserId(userId);
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public void addItem(@RequestBody AddItemRequestWrapper addItemRequestWrapper, Authentication authentication) {
        itemService.addItem(addItemRequestWrapper, authentication);
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
