package com.codecool.converter;

import com.codecool.model.AppUser;
import com.codecool.modelDTO.AppUserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppUserConverter {

    public AppUserDTO entityToDTO(AppUser appUser) {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setFirstName(appUser.getFirstName());
        appUserDTO.setLastName(appUser.getLastName());
        appUserDTO.setAddress(appUser.getAddress());
        appUserDTO.setCity(appUser.getCity());
        return appUserDTO;
    }

    public List<AppUserDTO> entitiesToDTO(List<AppUser> appUsers) {
        return appUsers.stream()
                .map(user -> entityToDTO(user))
                .collect(Collectors.toList());
    }



}

