package com.codecool.service;

import com.codecool.App;
import com.codecool.dao.UserRepository;
import com.codecool.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public AppUser getUserById(long id){
        return userRepository.getAppUsersById(id);
    }

    public List<AppUser> getAllAppUsers(){
        return userRepository.findAll();
    }

    public void addUser(AppUser appUser){
        userRepository.save(appUser);
    }

    public void updateUser(AppUser updatedUser){
        userRepository.save(updatedUser);
    }

    public void deleteUser(AppUser appUser){
        userRepository.deleteById(appUser.getId());
    }
}
