package com.passwordValidation.PasswordValidation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
        private String contact_no;
        private String gender;
        private int age;
        private String password;
        private String reenter_password;
        private String user_type;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "user")
        private List<Address> address;




}
