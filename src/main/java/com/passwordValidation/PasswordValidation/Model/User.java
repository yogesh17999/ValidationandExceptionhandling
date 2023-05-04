package com.passwordValidation.PasswordValidation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
        private String date;
        private String statusofuser;


        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(name = "User_address", joinColumns = @JoinColumn(name = "Pk_user_id"), inverseJoinColumns = @JoinColumn(name = "fk_addres_id"))
        private List<Address> address;




}
