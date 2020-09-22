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
        appUserDTO.setId(appUser.getId());
        appUserDTO.setFirstName(appUser.getFirstName());
        appUserDTO.setLastName(appUser.getLastName());
        appUserDTO.setAddress(appUser.getAddress());
        appUserDTO.setCity(appUser.getCity());
        appUserDTO.setLat(appUser.getLat());
        appUserDTO.setLng(appUser.getLng());
        return appUserDTO;
    }

    public List<AppUserDTO> entitiesToDTO(List<AppUser> appUsers) {
        return appUsers.stream()
                .map(user -> entityToDTO(user))
                .collect(Collectors.toList());
    }


    public AppUser DTOtoEntity(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser();
        appUser.setId(appUserDTO.getId());
        appUser.setFirstName(appUserDTO.getFirstName());
        appUser.setLastName(appUserDTO.getLastName());
        appUser.setAddress(appUserDTO.getAddress());
        appUser.setCity(appUserDTO.getCity());
        appUser.setLat(appUserDTO.getLat());
        appUser.setLng(appUserDTO.getLng());
        return appUser;
    }

}

