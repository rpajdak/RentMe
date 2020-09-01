package com.codecool.controller.api;

import com.codecool.converter.AppUserConverter;
import com.codecool.model.AppUser;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@CrossOrigin
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

    @GetMapping("/renters/{id}")
    @ResponseBody
    public AppUserDTO findUserById(@PathVariable("id") Long id) {
        return appUserConverter.entityToDTO(userService.getUserById(id));
    }

    @GetMapping("/renters/find-by/item/{id}")
    @ResponseBody
    public String findUserAddressByItemId(@PathVariable("id") Long id) {
        return userService.getUserAddressByItemId(id);
    }

    @GetMapping("/admins/{id}")
    @ResponseBody
    public AppUserDTO findAdminById(@PathVariable("id") Long id) {
        return appUserConverter.entityToDTO(userService.getUserById(id));
    }

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

    @DeleteMapping
    @ResponseBody
    public void deleteAppUser(long id) {
        userService.deleteUser(id);
    }

}
