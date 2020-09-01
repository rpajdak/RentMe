package com.codecool.dao;

import com.codecool.App;
import com.codecool.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser getAppUsersById(long id);

    AppUser deleteAppUserById(long id);

    @Query(value = "SELECT address, city  FROM  items  LEFT JOIN users ON items.owner_id = users.id WHERE items.owner_id =?1", nativeQuery = true)
    AppUser findAppUserAddressByItemId(long itemId);
}
