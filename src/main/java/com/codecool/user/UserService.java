package com.codecool.user;

import com.codecool.user.adressGeocoding.AddressGeocoder;
import com.codecool.user.domain.User;
import com.codecool.user.dto.UserDTO;
import com.codecool.user.dto.UserAddressDTO;
import com.codecool.user.dto.UserNameDTO;
import com.codecool.user.exception.GettingCoordinatesForUserException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

import static com.codecool.user.UserConverter.DTOtoEntity;
import static com.codecool.user.UserConverter.entityToDTO;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(long id) {
        return entityToDTO(userRepository.getUserById(id));
    }

    public User getEntityByEmail(String email) {
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
        UserNameDTO userNameDTO = new UserNameDTO();
        userNameDTO.setFirstName(splitName[0]);
        userNameDTO.setLastName(splitName[1]);
        return userNameDTO;
    }

    public List<User> getAllAppUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserDTO userDTO) {
        Map<String, Double> coordinatesForUser = getCoordinatesForUser(userDTO);
        userDTO.setLat(coordinatesForUser.get("lat"));
        userDTO.setLng(coordinatesForUser.get("lng"));

        userRepository.save(DTOtoEntity(userDTO));
    }

    public void updateUser(User updatedUser) {
        User existingUser = userRepository.getUserById(updatedUser.getId());
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

    public Boolean checkIfEmailAlreadyExist(UserDTO userDTO) {
        return userRepository.getUserByEmail(userDTO.getEmail()) != null;
    }

    public List<UserDTO> getAllAdmins() {
        return getAllAppUsers().stream()
                .filter(User::getIsAdmin)
                .map(UserConverter::entityToDTO)
                .collect(toList());
    }

    public List<UserDTO> getAllRenters() {
        return getAllAppUsers().stream()
                .filter(user -> !user.getIsAdmin())
                .map(UserConverter::entityToDTO)
                .collect(toList());
    }

    public UserDetails loadUserByUsername(String userName) {
        return userRepository.loadUserByUsername(userName);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
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

    public void save(User entityByEmail) {
        userRepository.save(entityByEmail);
    }

}