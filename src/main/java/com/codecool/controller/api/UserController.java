package com.codecool.controller.api;

import com.codecool.converter.AppUserConverter;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
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

}
