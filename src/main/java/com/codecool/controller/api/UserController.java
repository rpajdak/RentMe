package com.codecool.controller.api;

import com.codecool.model.AppUser;
import com.codecool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dummyAppUsers")
    @ResponseBody
    public void fillDbWithAppUsers() {
        userService.addUser(new AppUser("Joanna", "Brzuchacz", "jbrzuchacz@gmail.com", "asia1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Michał", "Kuk", "mkuk@gmail.com", "michal1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Miłosz", "Bryła", "mbryla@gmail.com", "milosz1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Rafał", "Pajdak", "rpajdak@gmail.com", "rafal1234", "Slusarska 9", "Krakow", true));
    }


    @GetMapping("/all")
    @ResponseBody
    public List<AppUser> getAllAppUsers() {
        return userService.getAllAppUsers();
    }
}
