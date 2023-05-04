package com.passwordValidation.PasswordValidation.Dto;

import com.passwordValidation.PasswordValidation.Model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addressdto {

@NotBlank
    private int pincode;
    private String Landmark;
    @NotBlank
    private String area;
    private String address_type;
}
