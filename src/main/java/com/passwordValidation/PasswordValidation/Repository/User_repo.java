package com.passwordValidation.PasswordValidation.Repository;

import com.passwordValidation.PasswordValidation.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface User_repo extends JpaRepository<User,Integer> {


    @Query(value = "SELECT * FROM user WHERE username =:username AND statusofuser = 'active'", nativeQuery = true)
    User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
