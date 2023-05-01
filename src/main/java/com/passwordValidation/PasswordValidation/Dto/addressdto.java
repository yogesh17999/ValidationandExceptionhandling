package com.passwordValidation.PasswordValidation.Dto;

import com.passwordValidation.PasswordValidation.Model.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class addressdto {

@NotBlank
@Size(min = 5, max = 5)
    private int pincode;
    private String Landmark;
    @NotBlank
    private String area;


}
