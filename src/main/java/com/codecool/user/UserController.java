package com.codecool.user;

import com.codecool.user.domain.User;
import com.codecool.user.dto.UserAddressDTO;
import com.codecool.user.dto.UserDTO;
import com.codecool.user.dto.UserDetailsWrapperDto;
import com.codecool.user.dto.UserNameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/admins", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<UserDTO> getAllAdmins() {
    return userService.getAllAdmins();
  }

  @GetMapping(value = "/renters", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<UserDTO> getAllRenters() {
    return userService.getAllRenters();
  }

  @GetMapping(value = "/renters/{id}", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public UserDTO getUserById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @GetMapping(value = "/renters", params = "email", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public User getUserByEmail(@RequestParam(value = "email") String email) {
    return userService.getUserByEmail(email);
  }

  @GetMapping(value = "/admins/{id}", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public UserDTO getAdminById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @GetMapping(value = "/address", params = "byItemId", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public UserAddressDTO getUserAddressByItemId(@RequestParam(value = "byItemId") Long itemId) {
    return userService.getUserAddressByItemId(itemId);
  }

  @GetMapping(params = "byItemId", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public UserNameDTO getUserNameByItemId(@RequestParam(value = "byItemId") Long itemId) {
    return userService.getUserNameByItemId(itemId);
  }

  @PostMapping()
  @ResponseBody
  @ResponseStatus(CREATED)
  public ResponseEntity<Object> addUser(@RequestBody UserDTO userDTO) {
    userService.addUser(userDTO);
    return ResponseEntity.status(CREATED).body("Account has been created.");
  }

  @PutMapping
  @ResponseBody
  @ResponseStatus(OK)
  public void updateUser(@RequestBody User user) {
    userService.updateUser(user);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  @ResponseStatus(NO_CONTENT)
  public void deleteAppUser(@PathVariable("id") long id) {
    userService.deleteUser(id);
  }

  @GetMapping("/address/{itemId}")
  @ResponseBody
  @ResponseStatus(OK)
  public UserDetailsWrapperDto getUserAddressByItemID(@PathVariable Long itemId) {
    return userService.getUserDetailsByItemId(itemId);
  }
}

