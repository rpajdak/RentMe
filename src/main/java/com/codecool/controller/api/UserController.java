package com.codecool.controller.api;

import com.codecool.converter.AppUserConverter;
import com.codecool.model.AppUser;
import com.codecool.modelDTO.UserAddressDTO;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.UserNameDTO;
import com.codecool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Controller
@CrossOrigin
@RestController
public class UserController {

    private UserService userService;
    private AppUserConverter appUserConverter;

    public UserController(UserService userService, AppUserConverter appUserConverter) {
        this.userService = userService;
        this.appUserConverter = appUserConverter;
    }

    @GetMapping("/admins/all")
    @ResponseBody
    public List<AppUserDTO> getAllAdmins() {

        return appUserConverter.entitiesToDTO(userService.getAllAdmins());
    }

    @GetMapping("/renters/all")
    @ResponseBody
    public List<AppUserDTO> getAllRenters() {
        return appUserConverter.entitiesToDTO(userService.getAllRenters());
    }

    @GetMapping(value = "/renters/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public AppUserDTO findUserById(@PathVariable("id") Long id) {
        return appUserConverter.entityToDTO(userService.getUserById(id));
    }
    //  renters/
    @GetMapping("/renters/find-by/item/{id}")
    @ResponseBody
    public UserAddressDTO findUserAddressByItemId(@PathVariable("id") Long id) {
        return userService.getUserAddressByItemId(id);
    }

    @GetMapping("/users/find-by/item/{id}")
    @ResponseBody
    public UserNameDTO findUserNameByItemId(@PathVariable("id") Long id) {
        return userService.getUserNameByItemId(id);
    }


    @GetMapping("/admins/{id}")
    @ResponseBody
    public AppUserDTO findAdminById(@PathVariable("id") Long id) {
        return appUserConverter.entityToDTO(userService.getUserById(id));
    }
    //STATUSY , app user musi byc DTO
    @PostMapping()
    @ResponseBody
    public void addUser(@RequestBody AppUser appUser) {
        userService.addUser(appUser);
    }

    @PutMapping
    @ResponseBody
    public void updateUser(@RequestBody AppUser appUser) {
        userService.updateUser(appUser);
    }

//   Just for test
    @PutMapping("/test")
    @ResponseBody
    public void justTest(@RequestBody String s){
        System.out.println(s);
    }


    @DeleteMapping
    @ResponseBody
    public void deleteAppUser(long id) {
        userService.deleteUser(id);
    }

}
