package com.passwordValidation.PasswordValidation.Dto;

import com.passwordValidation.PasswordValidation.Model.Address;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Updaterequest {

    @NotBlank(message = "Username shound not be empty!!")
    private String username;
    @Email(message = "Please enter correct email!!")
    private String email;
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{10})", message = "Please enter correct mobile no!!")
    private String user_mobile;
    private String gender;

    @Min(18)
    @Max(value = 50, message = "Please enter the Age between 18 to 50!!")
    private int age;

    private String password;
    private String reenter_password;
    private String user_type;
    @NotBlank
    private List<Address> address;
}

