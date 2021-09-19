package com.codecool.user;

import com.codecool.user.domain.AppUser;
import com.codecool.user.dto.AppUserDTO;
import com.codecool.user.dto.UserAddressDTO;
import com.codecool.user.dto.UserNameDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/admins", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<AppUserDTO> getAllAdmins() {
    return userService.getAllAdmins();
  }

  @GetMapping(value = "/renters", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<AppUserDTO> getAllRenters() {
    return userService.getAllRenters();
  }

  @GetMapping(value = "/renters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public AppUserDTO findUserById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @GetMapping(value = "/renters", params = "email", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public AppUserDTO findUserByEmail(@RequestParam(value = "email") String email) {
    return userService.getUserByEmail(email);
  }

  @GetMapping(value = "/admins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public AppUserDTO findAdminById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @GetMapping(value = "/address", params = "byItemId", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public UserAddressDTO findUserAddressByItemId(@RequestParam(value = "byItemId") Long itemId) {
    return userService.getUserAddressByItemId(itemId);
  }

  @GetMapping(params = "byItemId", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public UserNameDTO findUserNameByItemId(@RequestParam(value = "byItemId") Long itemId) {
    return userService.getUserNameByItemId(itemId);
  }

  @PostMapping()
  @ResponseBody
  @ResponseStatus(CREATED)
  public ResponseEntity<Object> addUser(@RequestBody AppUserDTO appUserDTO) {

    userService.addUser(appUserDTO);
    return ResponseEntity.status(CREATED).body("Account has been created.");
  }

  @PutMapping
  @ResponseBody
  @ResponseStatus(OK)
  public void updateUser(@RequestBody AppUser appUser) {
    userService.updateUser(appUser);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  @ResponseStatus(NO_CONTENT)
  public void deleteAppUser(@PathVariable("id") long id) {
    userService.deleteUser(id);
  }

  @GetMapping("/")
  @ResponseBody
  public Collection<Long> getItemsIdByUserId() {
    return userService.getItemsIdByUserId(4);
  }
}

