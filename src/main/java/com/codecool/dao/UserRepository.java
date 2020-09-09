package com.codecool.dao;

import com.codecool.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser getAppUsersById(long id);

    AppUser deleteAppUserById(long id);


    @Query("SELECT  u.address, u.city, u.postCode  FROM Item i LEFT JOIN AppUser u ON i.ownerId = u.id WHERE i.ownerId =:itemId" )
    String[]  findAppUserAddressByItemId(long itemId);


}

