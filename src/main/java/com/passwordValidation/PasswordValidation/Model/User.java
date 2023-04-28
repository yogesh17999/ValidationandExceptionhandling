package com.passwordValidation.PasswordValidation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

        @Id
        @GeneratedValue
        private int uder_id;
        private String username;
        private String email;
        private String user_mobile;
        private String gender;
        private int age;
        private String password;
        private String reenter_password;
        private String user_type;



}
