package com.codecool.service;

import com.codecool.dao.UserRepository;
import com.codecool.model.AppUser;
import com.codecool.modelDTO.UserAddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser getUserById(long id) {
        return userRepository.getAppUsersById(id);
    }

    public UserAddressDTO getUserAddressByItemId(long id){
        String userAddress = userRepository.findAppUserAddressByItemId(id)[0];
        String[] splitString = userAddress.split(",");
        UserAddressDTO userAddressDTO = new UserAddressDTO();
        userAddressDTO.setAddress(splitString[0]);
        userAddressDTO.setCity(splitString[1]);
        userAddressDTO.setPostCode(splitString[2]);
        return userAddressDTO;
    }

    public List<AppUser> getAllAppUsers() {
        return userRepository.findAll();
    }

    public void addUser(AppUser appUser) {
        userRepository.save(appUser);
    }

    public void updateUser(AppUser updatedUser) {
        userRepository.save(updatedUser);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }



    public List<AppUser> getAllAdmins() {
        return getAllAppUsers().stream()
                .filter(AppUser::getIsAdmin)
                .collect(Collectors.toList());
    }

    public List<AppUser> getAllRenters() {
        return getAllAppUsers().stream()
                .filter(user -> !user.getIsAdmin())
                .collect(Collectors.toList());
    }
}
