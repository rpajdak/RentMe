package com.codecool.user;

import lombok.AllArgsConstructor;

import com.codecool.user.adressGeocoding.AddressGeocoder;
import com.codecool.user.domain.User;
import com.codecool.user.dto.UserAddressDTO;
import com.codecool.user.dto.UserDTO;
import com.codecool.user.dto.UserDetailsWrapperDto;
import com.codecool.user.dto.UserNameDTO;
import com.codecool.user.exception.GettingCoordinatesForUserException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

import static com.codecool.user.UserConverter.DTOtoEntity;
import static com.codecool.user.UserConverter.entityToDTO;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;

  public UserDTO getUserById(long id) {
    return entityToDTO(userRepository.getUserById(id));
  }

  public User getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  public UserAddressDTO getUserAddressByItemId(long id) {
    String userAddress = null;
    String[] splitString = userAddress.split(",");
    UserAddressDTO userAddressDTO = new UserAddressDTO();
    userAddressDTO.setAddress(splitString[0]);
    userAddressDTO.setCity(splitString[1]);
    userAddressDTO.setPostCode(splitString[2]);
    return userAddressDTO;
  }

  public UserNameDTO getUserNameByItemId(long id) {
    String userName = null;
    String[] splitName = userName.split(",");
    UserNameDTO userNameDTO = UserNameDTO.builder()
        .firstName(splitName[0])
        .lastName(splitName[1])
        .build();
    return userNameDTO;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Boolean checkIfEmailAlreadyExists(UserDTO userDTO) {
    return userRepository.getUserByEmail(userDTO.getEmail()) != null;
  }

  public List<UserDTO> getAllAdmins() {
    return getAllUsers().stream()
        .filter(User::getIsAdmin)
        .map(UserConverter::entityToDTO)
        .collect(toList());
  }

  public List<UserDTO> getAllRenters() {
    return getAllUsers().stream()
        .filter(user -> !user.getIsAdmin())
        .map(UserConverter::entityToDTO)
        .collect(toList());
  }

  public UserDetails getUserSecurityDetailsByEmail(String email) {
    return userRepository.getUserSecurityDetailsByEmail(email);
  }

  private Map<String, Double> getCoordinatesForUser(UserDTO userDTO) {
    try {
      return AddressGeocoder.getCoordinates(
          userDTO.getAddress() + " " + userDTO.getCity());
    } catch (Exception e) {
      throw new GettingCoordinatesForUserException(
          format("Getting coordinates for user %s failed", userDTO.getEmail()), e);
    }
  }

  public void addUser(UserDTO userDTO) {
    Map<String, Double> coordinatesForUser = getCoordinatesForUser(userDTO);
    userDTO.setLat(coordinatesForUser.get("lat"));
    userDTO.setLng(coordinatesForUser.get("lng"));

    userRepository.save(DTOtoEntity(userDTO));
  }

  public void updateUser(User updatedUser) {
    User user = userRepository.getUserById(updatedUser.getId());
    user.setFirstName(updatedUser.getFirstName());
    user.setLastName(updatedUser.getLastName());
    user.setEmail(updatedUser.getEmail());
    user.setAddress(updatedUser.getAddress());
    user.setPostCode(updatedUser.getPostCode());
    user.setCity(updatedUser.getCity());
    user.setPassword(updatedUser.getPassword());
    userRepository.save(user);
  }

  public void deleteUser(long id) {
    userRepository.deleteById(id);
  }

  UserDetailsWrapperDto getUserDetailsByItemId(Long itemId) {
    return convertToDto(userRepository.getUserDetailsByItemId(itemId));
  }

  UserDetailsWrapperDto convertToDto(String[] userDetails) {
    String[] splitDetails = userDetails[0].split(",");

    UserNameDTO userName = UserNameDTO.builder()
        .firstName(splitDetails[0])
        .lastName(splitDetails[1])
        .build();

    UserDetailsAddressDTO userAddress = UserDetailsAddressDTO.builder()
        .city(splitDetails[2])
        .address(splitDetails[3])
        .lat(splitDetails[4])
        .lng(splitDetails[5])
        .build();

    return UserDetailsWrapperDto.builder()
        .userName(userName)
        .userDetailsAddress(userAddress)
        .build();
  }
}
