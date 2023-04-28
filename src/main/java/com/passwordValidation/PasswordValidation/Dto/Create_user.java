package com.passwordValidation.PasswordValidation.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Create_user {
    @NotBlank(message = "Username shound not be empty!!")
    private String username;
    @Email(message = "Please enter correct email!!")
    private String email;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please enter correct mobile no!!")
    private String user_mobile;
    private String gender;

    @Min(18)
    @Max(value = 50, message = "Please enter the Age between 18 to 50!!")
    private int age;

    private String password;
    private String reenter_password;
    private String user_type;
}