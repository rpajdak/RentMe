package com.codecool.user;

import com.codecool.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {

  User getUserById(long id);

  User getUserByEmail(String email);

  User deleteUserById(long id);

  @Query(value = "SELECT u.address, u.city, u.post_code FROM Users u " +
      " LEFT JOIN users_items ui ON u.id = ui.user_id" +
      " WHERE ui.items_id =:itemId", nativeQuery = true)
  String[] getUserAddressByItemId(long itemId);

  @Query(value = "SELECT u.first_name, u.last_name FROM Users u " +
      " LEFT JOIN users_items ui ON u.id = ui.user_id" +
      " LEFT JOIN items i ON ui.items_id = i.id" +
      " WHERE i.id =:itemId", nativeQuery = true)
  String getUserFullNameByItemId(long itemId);

  @Query("SELECT u.email, u.password, u.enabled from User u where u.email = :email")
  UserDetails getUserSecurityDetailsByEmail(String email);

  @Query(value = "SELECT items_id FROM users_items WHERE user_id = :userId", nativeQuery = true)
  Collection<Long> getItemsIdByUserId(long userId);

  @Query(value = "SELECT users.first_name, users.last_name, "
      + "users.city, users.address, users.lat, users.lng "
      + "FROM users "
      + "JOIN users_item_list uil ON uil.app_user_user_id = users.id "
      + "WHERE item_list_id = :itemId", nativeQuery = true)
  String[] getUserDetailsByItemId(Long itemId);
}
