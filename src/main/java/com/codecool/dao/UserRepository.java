package com.codecool.dao;

import com.codecool.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser getAppUsersById(long id);

    AppUser deleteAppUserById(long id);

    @Query("SELECT o.address, o.city, o.postCode FROM Item i LEFT JOIN i.owner o WHERE i.id =:itemId")
    String[] findAppUserAddressByItemId(long itemId);

    @Query("SELECT o.firstName, o.lastName FROM Item i LEFT JOIN i.owner o WHERE i.id =:itemId")
    String findAppUserNmeByItemId(long itemId);
}

