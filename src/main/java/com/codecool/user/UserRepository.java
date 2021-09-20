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

//  @Query("SELECT o.address, o.city, o.postCode FROM Item i LEFT JOIN i.owner o WHERE i.id =:itemId")
//  String[] findAppUserAddressByItemId(long itemId);
//
//  @Query("SELECT o.firstName, o.lastName FROM Item i LEFT JOIN i.owner o WHERE i.id =:itemId")
//  String findAppUserNmeByItemId(long itemId);

  @Query("SELECT u.email,u.password,u.enabled from User u where u.email = :userName")
  UserDetails loadUserByUsername(String userName);

  @Query(value = "SELECT item_list_id FROM users_item_list WHERE  app_user_user_id = :userId", nativeQuery = true)
  Collection<Long> getItemsIdByUserId(Long userId);
}
