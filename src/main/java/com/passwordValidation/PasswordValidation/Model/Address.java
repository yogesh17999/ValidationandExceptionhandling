package com.passwordValidation.PasswordValidation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private int add_id;
    private int pincode;
    private String Landmark;
    private String area;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;



}
