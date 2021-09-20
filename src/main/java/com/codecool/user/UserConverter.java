package com.codecool.user;

import com.codecool.user.domain.User;
import com.codecool.user.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

  public static UserDTO entityToDTO(User user) {
    UserDTO userDTO = UserDTO.builder().build();
    userDTO.setId(user.getId());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setEmail(user.getEmail());
    userDTO.setAddress(user.getAddress());
    userDTO.setPostCode(user.getPostCode());
    userDTO.setCity(user.getCity());
    userDTO.setIsAdmin(user.getIsAdmin());
    userDTO.setLat(user.getLat());
    userDTO.setLng(user.getLng());
    userDTO.setEnabled(user.getEnabled());
    return userDTO;
  }

  public static List<UserDTO> entitiesToDTO(List<User> users) {
    return users.stream()
        .map(UserConverter::entityToDTO)
        .collect(Collectors.toList());
  }


  public static User DTOtoEntity(UserDTO userDTO) {
    User user = new User();
    user.setId(userDTO.getId());
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setEmail(userDTO.getEmail());
    user.setAddress(userDTO.getAddress());
    user.setPostCode(userDTO.getPostCode());
    user.setCity(userDTO.getCity());
    user.setLat(userDTO.getLat());
    user.setLng(userDTO.getLng());
    user.setEmail(userDTO.getEmail());
    user.setPostCode(userDTO.getPostCode());
    user.setRole(userDTO.getRole());
    user.setPassword(userDTO.getPassword());
    user.setIsAdmin(userDTO.getIsAdmin());
    user.setEnabled(userDTO.getEnabled());
    return user;
  }

}

