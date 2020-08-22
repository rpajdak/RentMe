package com.codecool.controller.api;

import com.codecool.model.AppUser;
import com.codecool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admins/all")
    @ResponseBody
    public List<AppUser> getAllAdmins() {
        return userService.getAllAppUsers().stream()
                .filter(AppUser::getIsAdmin)
                .collect(Collectors.toList());
    }

    @GetMapping("/renters/all")
    @ResponseBody
    public List<AppUser> getAllRenters(){
        return userService.getAllAppUsers().stream()
                .filter(user -> !user.getIsAdmin())
                .collect(Collectors.toList());
    }
    @GetMapping("/renters/{id}")
    @ResponseBody
    public AppUser findUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

}
