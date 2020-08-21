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

    @GetMapping("/fillWithDummyAppUsers")
    @ResponseBody
    public void fillDbWithAppUsers() {
        userService.addUser(new AppUser("Joanna", "Brzuchacz", "jbrzuchacz@gmail.com", "asia1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Michał", "Kuk", "mkuk@gmail.com", "michal1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Miłosz", "Bryła", "mbryla@gmail.com", "milosz1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Rafał", "Pajdak", "rpajdak@gmail.com", "rafal1234", "Slusarska 9", "Krakow", true));
        userService.addUser(new AppUser("Maciek", "Bolek", "mbolek@gmail.com", "maciek1234", "Ceglarska 9", "Krakow", false));
        userService.addUser(new AppUser("Julia", "Nowosad", "jnowosad@gmail.com", "julia1234", "Książnicza 9", "Krakow", false));
        userService.addUser(new AppUser.Builder()
                .firstName("Dorota")
                .lastName("Bażant")
                .email("dbazant@gmail.com")
                .password("dorota1234")
                .address("Karmelicka 1")
                .city("Kraków")
                .isAdmin(false)
                .build());
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
