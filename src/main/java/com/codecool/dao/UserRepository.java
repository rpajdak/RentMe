package com.codecool.dao;

import com.codecool.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser getAppUsersById(long id);

    AppUser deleteAppUserById(long id);
}
