package com.passwordValidation.PasswordValidation.Repository;

import com.passwordValidation.PasswordValidation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_repo extends JpaRepository<User,Integer> {


    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
