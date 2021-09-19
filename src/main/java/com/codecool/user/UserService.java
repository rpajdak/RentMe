package com.codecool.user;

import com.codecool.api.CallGeocodingApi;
import com.codecool.user.domain.AppUser;
import com.codecool.user.domain.AppUserConverter;
import com.codecool.user.dto.AppUserDTO;
import com.codecool.user.dto.UserAddressDTO;
import com.codecool.user.dto.UserNameDTO;
import com.codecool.user.exception.GettingCoordinatesForUserException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.codecool.user.domain.AppUserConverter.DTOtoEntity;
import static com.codecool.user.domain.AppUserConverter.entityToDTO;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public AppUserDTO getUserById(long id) {
    return entityToDTO(userRepository.getAppUsersById(id));
  }

  public AppUser getEntityByEmail(String email) {
    return userRepository.getAppUsersByEmail(email);
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
    UserNameDTO userNameDTO = new UserNameDTO();
    userNameDTO.setFirstName(splitName[0]);
    userNameDTO.setLastName(splitName[1]);
    return userNameDTO;
  }

  public List<AppUser> getAllAppUsers() {
    return userRepository.findAll();
  }

  public void addUser(AppUserDTO appUserDTO) {
    Map<String, Double> coordinatesForUser = getCoordinatesForUser(appUserDTO);
    appUserDTO.setLat(coordinatesForUser.get("lat"));
    appUserDTO.setLng(coordinatesForUser.get("lng"));

    userRepository.save(DTOtoEntity(appUserDTO));
  }

  public void updateUser(AppUser updatedUser) {
    AppUser existingUser = userRepository.getAppUsersById(updatedUser.getId());
    existingUser.setFirstName(updatedUser.getFirstName());
    existingUser.setLastName(updatedUser.getLastName());
    existingUser.setEmail(updatedUser.getEmail());
    existingUser.setAddress(updatedUser.getAddress());
    existingUser.setPostCode(updatedUser.getPostCode());
    existingUser.setCity(updatedUser.getCity());
    existingUser.setPassword(updatedUser.getPassword());
    userRepository.save(existingUser);
  }

  public void deleteUser(long id) {
    userRepository.deleteById(id);
  }

  public Boolean checkIfEmailAlreadyExist(AppUserDTO appUserDTO) {
    return userRepository.getAppUsersByEmail(appUserDTO.getEmail()) != null;
  }

  public List<AppUserDTO> getAllAdmins() {
    return getAllAppUsers().stream()
        .filter(AppUser::getIsAdmin)
        .map(AppUserConverter::entityToDTO)
        .collect(toList());
  }

  public List<AppUserDTO> getAllRenters() {
    return getAllAppUsers().stream()
        .filter(user -> !user.getIsAdmin())
        .map(AppUserConverter::entityToDTO)
        .collect(toList());
  }

  public UserDetails loadUserByUsername(String userName) {
    return userRepository.loadUserByUsername(userName);
  }

  public AppUserDTO getUserByEmail(String email) {
    return entityToDTO(userRepository.getAppUsersByEmail(email));
  }

  private Map<String, Double> getCoordinatesForUser(AppUserDTO appUserDTO) {
    try {
      return CallGeocodingApi.getCoordinates(
          appUserDTO.getAddress() + " " + appUserDTO.getCity());
    } catch (Exception e) {
      throw new GettingCoordinatesForUserException(
          format("Getting coordinates for user %s failed", appUserDTO.getEmail()), e);
    }
  }

  public void save(AppUser entityByEmail) {
    userRepository.save(entityByEmail);
  }

  Collection<Long> getItemsIdByUserId(long i) {
    return userRepository.getItemsIdByUserId(i);
  }
}

